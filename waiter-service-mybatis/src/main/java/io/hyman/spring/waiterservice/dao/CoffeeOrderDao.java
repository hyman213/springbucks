package io.hyman.spring.waiterservice.dao;

import io.hyman.spring.waiterservice.model.CoffeeOrder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description:
 * @author: Hyman
 * @date: 2019/07/27 21:43
 * @version： 1.0.0
 */
@Mapper
public interface CoffeeOrderDao {

    @Insert("INSERT INTO t_order_coffee(coffee_order_id, items_id) VALUES (#{coffee_order_id}, #{items_id})")
    boolean createCoffeeOrder(CoffeeOrder coffeeOrder);

}
