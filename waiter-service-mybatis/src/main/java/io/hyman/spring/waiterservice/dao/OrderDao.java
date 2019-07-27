package io.hyman.spring.waiterservice.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.core.annotation.Order;

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

    @Insert("INSERT INTO t_order(customer, state, create_time, update_time) VALUES (#{customer}, #{state}, now(), now())")
    void create(Order order);

}
