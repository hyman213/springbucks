package io.hyman.spring.waiterservice.controller;

import io.hyman.spring.waiterservice.model.NewOrderRequest;
import io.hyman.spring.waiterservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @author: Hyman
 * @date: 2019/07/27 21:45
 * @version： 1.0.0
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void create(@RequestBody NewOrderRequest orderRequest) {
        orderService.createA(orderRequest.getCustomer(), orderRequest.getItems());
    }

}
