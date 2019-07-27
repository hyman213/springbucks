package io.hyman.spring.waiterservice.controller;

import io.hyman.spring.waiterservice.model.Coffee;
import io.hyman.spring.waiterservice.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @author: Hyman
 * @date: 2019/07/27 11:26
 * @version： 1.0.0
 */
@RestController
@RequestMapping("/coffee")
public class CoffeeController {

    @Autowired
    private CoffeeService coffeeService;

    @PostMapping("/name")
    public Coffee findByName(String name) {
        return coffeeService.findByName(name);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createCoffee(@RequestBody Coffee coffee) {
        coffeeService.create(coffee);
    }


}
