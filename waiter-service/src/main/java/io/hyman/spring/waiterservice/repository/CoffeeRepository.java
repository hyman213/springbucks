package io.hyman.spring.waiterservice.repository;

import io.hyman.spring.waiterservice.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Description:
 * @author: Hyman
 * @date: 2019/07/22 20:29
 * @version： 1.0.0
 */
public interface CoffeeRepository extends JpaRepository<Coffee, Long> {

    Coffee findByName(String name);

    List<Coffee> findByNameInOrderById(List<String> list);

}
