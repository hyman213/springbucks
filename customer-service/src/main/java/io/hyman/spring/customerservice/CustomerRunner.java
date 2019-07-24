package io.hyman.spring.customerservice;

import io.hyman.spring.customerservice.model.Coffee;
import io.hyman.spring.customerservice.model.CoffeeOrder;
import io.hyman.spring.customerservice.model.NewOrderRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @author: Hyman
 * @date: 2019/07/24 08:13
 * @version： 1.0.0
 */
@Component
@Slf4j
public class CustomerRunner implements ApplicationRunner {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        readMenu();
        Long id = orderCoffee();
        queryOrder(id);
        // 测试@ManyToMany删除
        deleteOrder(id);
    }

    private void deleteOrder(Long id) {
        CoffeeOrder order = restTemplate.getForObject("http://localhost:8080/order/del/{id}", CoffeeOrder.class, id);
        log.info("Order: {}", order);
    }

    private void queryOrder(Long id) {
        CoffeeOrder order = restTemplate.getForObject("http://localhost:8080/order/{id}", CoffeeOrder.class, id);
        log.info("Order: {}", order);
    }

    private Long orderCoffee() {
        // 自动创建t_order和t_order_coffee
        NewOrderRequest orderRequest = NewOrderRequest.builder()
                .customer("Li Lei")
                .items(Arrays.asList("capuccino", "Americano"))// 在t_coffee中存在
                .build();
        RequestEntity<NewOrderRequest> requestEntity = RequestEntity
                .post(UriComponentsBuilder.fromUriString("http://localhost:8080/order/").build().toUri())
                .body(orderRequest);
        ResponseEntity<CoffeeOrder> responseEntity = restTemplate.exchange(requestEntity, CoffeeOrder.class);
        log.info("Create OrderCoffee: {}", responseEntity.getBody());
        Long id = responseEntity.getBody().getId();
        log.info("Order ID: {}", id);
        return id;
    }

    private void readMenu() {
        ParameterizedTypeReference<List<Coffee>> ptr = new ParameterizedTypeReference<List<Coffee>>() {
        };
        ResponseEntity<List<Coffee>> list = restTemplate.exchange("http://localhost:8080/coffee/", HttpMethod.GET, null, ptr);
        list.getBody().forEach(c -> log.info("coffee: {}", c));
    }


}
