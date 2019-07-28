package io.hyman.spring.waiterservice.service;

import io.hyman.spring.waiterservice.dao.CoffeeOrderDao;
import io.hyman.spring.waiterservice.model.CoffeeOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(propagation = Propagation.NESTED, isolation = Isolation.READ_COMMITTED)
    public boolean createB(long orderId, long itemId) {
        coffeeOrderDao.createCoffeeOrder(CoffeeOrder.builder().orderid(orderId).itemid(itemId).build());
//        System.out.println(1 / 0);
        return true;
    }
}
