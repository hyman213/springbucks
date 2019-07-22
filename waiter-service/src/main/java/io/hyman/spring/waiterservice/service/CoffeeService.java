package io.hyman.spring.waiterservice.service;

import io.hyman.spring.waiterservice.model.Coffee;
import io.hyman.spring.waiterservice.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @author: Hyman
 * @date: 2019/07/22 20:34
 * @version： 1.0.0
 */
@Service
@Slf4j
@CacheConfig(cacheNames = "CoffeeCache")
public class CoffeeService {

    @Autowired
    private CoffeeRepository coffeeRepository;

    public Coffee saveCoffee(String name, Money price){
        return coffeeRepository.save(Coffee.builder().name(name).price(price).build());
    }

    /**
     * 通过Id查找Coffee
     *
     * @param id
     * @return
     */
    public Coffee getCoffeeById(Long id) {
        return coffeeRepository.findById(id).get();
    }

    /**
     * 通过name查找Coffee
     *
     * @param name
     * @return
     */
    public Coffee getCoffeeByName(String name) {
        return coffeeRepository.findByName(name);
    }

    /**
     * 查询所有Coffee，按Id排序
     *
     * @return
     */
    public List<Coffee> getAllCoffee() {
        return coffeeRepository.findAll(Sort.by("id"));
    }

    /**
     * 查询names的Coffee，按Id排序
     *
     * @param names
     * @return
     */
    public List<Coffee> getCoffeeByName(List<String> names) {
        return coffeeRepository.findByNameInOrderById(names);
    }

}
