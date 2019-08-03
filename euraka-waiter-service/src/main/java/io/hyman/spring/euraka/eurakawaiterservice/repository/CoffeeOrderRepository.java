package io.hyman.spring.euraka.eurakawaiterservice.repository;

import io.hyman.spring.euraka.eurakawaiterservice.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}
