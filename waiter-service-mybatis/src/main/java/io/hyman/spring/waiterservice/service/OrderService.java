package io.hyman.spring.waiterservice.service;

import io.hyman.spring.waiterservice.dao.CoffeeOrderDao;
import io.hyman.spring.waiterservice.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private ;


    public boolean create(String customer, List<String> items) {

        return false;
    }
}
