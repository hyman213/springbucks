package io.hyman.spring.waiterservice.controller;

import io.hyman.spring.waiterservice.controller.request.NewOrderRequest;
import io.hyman.spring.waiterservice.model.Coffee;
import io.hyman.spring.waiterservice.model.CoffeeOrder;
import io.hyman.spring.waiterservice.service.CoffeeOrderService;
import io.hyman.spring.waiterservice.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @author: Hyman
 * @date: 2019/07/22 21:03
 * @version： 1.0.0
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class CoffeeOrderController {
    @Autowired
    private CoffeeOrderService orderService;
    @Autowired
    private CoffeeService coffeeService;

    @GetMapping("/{id}")
    public CoffeeOrder getOrder(@PathVariable("id") Long id) {
        CoffeeOrder order = orderService.getCoffeeOrderById(id);
        log.info("Get Order: {}", order);
        return order;
    }

    @GetMapping("del/{id}")
    public CoffeeOrder delOrder(@PathVariable("id") Long id) {
        CoffeeOrder order = orderService.delCoffeeOrderById(id);
        log.info("Del Order: {}", order);// 加日志后，Client接收才不为null
        return order;
    }

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public CoffeeOrder create(@RequestBody NewOrderRequest newOrder) {
        log.info("Receive new Order {}", newOrder);
        Coffee[] coffeeList = coffeeService.getCoffeeByName(newOrder.getItems())
                .toArray(new Coffee[]{});
        return orderService.createOrder(newOrder.getCustomer(), coffeeList);
    }
}
