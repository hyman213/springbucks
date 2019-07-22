package io.hyman.spring.waiterservice.repository;

import io.hyman.spring.waiterservice.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description:
 * @author: Hyman
 * @date: 2019/07/22 20:33
 * @version： 1.0.0
 */
public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {

}
