package io.hyman.spring.waiterservice.service;

import io.hyman.spring.waiterservice.dao.CoffeeOrderDao;
import io.hyman.spring.waiterservice.model.CoffeeOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @author: Hyman
 * @date: 2019/07/27 22:04
 * @version： 1.0.0
 */
@Service
public class CoffeeOrderService {

    @Autowired
    private CoffeeOrderDao coffeeOrderDao;

    public boolean create(int orderId, int itemId) {
        coffeeOrderDao.createCoffeeOrder(CoffeeOrder.builder().)
    }

}
