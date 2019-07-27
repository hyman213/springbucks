package io.hyman.spring.waiterservice.service;

import io.hyman.spring.waiterservice.dao.CoffeeDao;
import io.hyman.spring.waiterservice.model.Coffee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void create(Coffee coffee) {
        coffeeDao.create(coffee);
        updateById(1);
    }

//    @Transactional(propagation = Propagation.REQUIRED)
    public boolean updateById(int id) {
        coffeeDao.updateById(id);
        System.out.println(1/0);
        return true;
    }
}
