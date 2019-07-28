package io.hyman.spring.waiterservice.service;

import io.hyman.spring.waiterservice.dao.CoffeeDao;
import io.hyman.spring.waiterservice.dao.OrderDao;
import io.hyman.spring.waiterservice.model.Coffee;
import io.hyman.spring.waiterservice.model.Order;
import io.hyman.spring.waiterservice.model.OrderState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description:
 * @author: Hyman
 * @date: 2019/07/27 11:23
 * @version： 1.0.0
 */
@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private CoffeeOrderService coffeeOrderService;

    @Autowired
    private CoffeeDao coffeeDao;

    @Transactional
    public boolean createA(String customer, List<String> items) {
        Order order = this.createOrder(customer, OrderState.INIT);
        Long orderId = order.getId();
        for (String item : items) {
            Coffee coffee = coffeeDao.findByName(item);
            if (coffee != null) {
                coffeeOrderService.createB(orderId, coffee.getId());
            }
        }
        System.out.println(1 / 0);
        return true;
    }

    public Order createOrder(String customer, OrderState state) {
        Order order = Order.builder().customer(customer).state(state).build();
        orderDao.create(order);
        return order;
    }
}
