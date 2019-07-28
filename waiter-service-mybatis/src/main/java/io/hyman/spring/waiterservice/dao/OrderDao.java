package io.hyman.spring.waiterservice.dao;

import io.hyman.spring.waiterservice.model.Order;
import org.apache.ibatis.annotations.*;

/**
 * @Description:
 * @author: Hyman
 * @date: 2019/07/26 23:17
 * @version： 1.0.0
 */
@Mapper
public interface OrderDao {

    @Select("SELECT * FROM t_order WHERE id = #{id}")
    Order selectById(@Param("id") String id);

    @Insert("INSERT INTO t_order(customer, state, create_time, update_time) VALUES (#{customer}, #{state, typeHandler=io.hyman.spring.waiterservice.dao.OrderStateHandler}, now(), now())")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")

    void create(Order order);

}
