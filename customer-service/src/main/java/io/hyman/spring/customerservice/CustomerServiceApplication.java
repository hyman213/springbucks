package io.hyman.spring.customerservice;

import io.hyman.spring.customerservice.support.CustomConnectionKeepAliveStrategy;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@Slf4j
public class CustomerServiceApplication {

    @Autowired
    private RestTemplate restTemplate;

    public static void main(String[] args) {
//        SpringApplication.run(CustomerServiceApplication.class, args);
        new SpringApplicationBuilder()
                .sources(CustomerServiceApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .web(WebApplicationType.NONE)
                .run(args);
    }

//    @Bean
//    public RestTemplate restTemplate(RestTemplateBuilder builder) {
//        return builder.build();
//    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .setConnectTimeout(Duration.ofMillis(100))
                .setReadTimeout(Duration.ofMillis(500))
                .requestFactory(this::requestFactory).build();
    }

    @Bean
    public HttpComponentsClientHttpRequestFactory requestFactory() {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(30, TimeUnit.SECONDS);
        connectionManager.setMaxTotal(200);
        connectionManager.setDefaultMaxPerRoute(20);

        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(connectionManager)
                .evictIdleConnections(30, TimeUnit.SECONDS)
                .disableAutomaticRetries()
                // 有 Keep-Alive 认里面的值，没有的话永久有效
                //.setKeepAliveStrategy(DefaultConnectionKeepAliveStrategy.INSTANCE)
                // 换成自定义的
                .setKeepAliveStrategy(new CustomConnectionKeepAliveStrategy()).build();

        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        return requestFactory;
    }

//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080/coffee/{id}").build(1);
//        ResponseEntity<Coffee> c = restTemplate.getForEntity(url, Coffee.class);
//        log.info("Response Status: {}, Response Headers: {}", c.getStatusCode(), c.getHeaders().toString());
//        log.info("Coffee: {}", c.getBody());
//
//        // 最后的"/"不能省
//        String coffeeUri = "http://localhost:8080/coffee/";
//        Coffee americano = Coffee.builder()
//                .name("Americano")
//                .price(BigDecimal.valueOf(25.00)).build();
//        ResponseEntity<Coffee> response = restTemplate.postForEntity(coffeeUri, americano, Coffee.class);
//        log.info("New Coffee: {}", response);
//
//        String s = restTemplate.getForObject(coffeeUri, String.class);
//        log.info(s);
//    }
}
