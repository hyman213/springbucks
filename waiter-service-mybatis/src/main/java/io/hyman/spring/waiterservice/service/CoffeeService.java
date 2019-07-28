package io.hyman.spring.waiterservice.service;

import io.hyman.spring.waiterservice.dao.CoffeeDao;
import io.hyman.spring.waiterservice.model.Coffee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description:
 * @author: Hyman
 * @date: 2019/07/27 11:23
 * @version： 1.0.0
 */
@Service
public class CoffeeService {

    @Autowired
    private CoffeeDao coffeeDao;

    public Coffee findByName(String name) {
        return coffeeDao.findByName(name);
    }

    @Transactional
    public void create(Coffee coffee) {
        coffeeDao.create(coffee);
        updateById(1);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public boolean updateById(int id) {
        coffeeDao.updateById(id);
        System.out.println(1 / 0);
        return true;
    }
}
