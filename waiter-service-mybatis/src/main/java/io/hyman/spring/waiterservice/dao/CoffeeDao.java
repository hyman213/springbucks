package io.hyman.spring.waiterservice.dao;

import io.hyman.spring.waiterservice.model.Coffee;
import org.apache.ibatis.annotations.*;

/**
 * @Description:
 * @author: Hyman
 * @date: 2019/07/26 23:17
 * @version： 1.0.0
 */
@Mapper
public interface CoffeeDao {

    @Select("SELECT * FROM t_coffee WHERE name = #{name}")
    Coffee findByName(@Param("name") String name);

    @Insert("INSERT INTO t_coffee(name, price, create_time, update_time) VALUES (#{name}, #{price}, now(), now())")
    void create(Coffee coffee);

    @Update("UPDATE t_coffee SET price = 25 WHERE id = #{id}")
    boolean updateById(int id);
}
