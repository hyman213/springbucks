package io.hyman.spring.waiterservice.service;

import io.hyman.spring.waiterservice.model.Coffee;
import io.hyman.spring.waiterservice.model.CoffeeOrder;
import io.hyman.spring.waiterservice.model.OrderState;
import io.hyman.spring.waiterservice.repository.CoffeeOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

/**
 * @Description:
 * @author: Hyman
 * @date: 2019/07/22 20:47
 * @version： 1.0.0
 */
@Service
@Transactional
@Slf4j
public class CoffeeOrderService {

    @Autowired
    private CoffeeOrderRepository coffeeOrderRepository;

    /**
     * 通过id查询CoffeeOrder
     *
     * @param id
     * @return
     */
    public CoffeeOrder getCoffeeOrderById(Long id) {
        return coffeeOrderRepository.getOne(id);
    }

    /**
     * 创建新订单
     *
     * @param customer
     * @param coffees
     * @return
     */
    public CoffeeOrder createOrder(String customer, Coffee... coffees) {
        CoffeeOrder coffeeOrder = CoffeeOrder.builder()
                .customer(customer)
                .items(new ArrayList<>(Arrays.asList(coffees)))
                .state(OrderState.INIT)
                .build();
        CoffeeOrder order = coffeeOrderRepository.save(coffeeOrder);
        log.info("New Order: {}", order);
        return order;
    }


    /**
     * 更新订单状态
     *
     * @param order
     * @param state
     * @return
     */
    public boolean updateOrderState(CoffeeOrder order, OrderState state) {
        if (state.compareTo(order.getState()) <= 0) {
            log.warn("Wrong State order: {}, {}", state, order.getState());
            return false;
        }
        order.setState(state);
        coffeeOrderRepository.save(order);
        log.info("Update order: {}", order);
        return true;
    }

    /**
     * 删除order-测试@ManyToMany
     *
     * @param id
     * @return
     */
    public CoffeeOrder delCoffeeOrderById(Long id) {
//        Optional<CoffeeOrder> byId = coffeeOrderRepository.findById(id);
        CoffeeOrder order = coffeeOrderRepository.getOne(id);
//        coffeeOrderRepository.deleteById(id);
        return order;
    }
}
