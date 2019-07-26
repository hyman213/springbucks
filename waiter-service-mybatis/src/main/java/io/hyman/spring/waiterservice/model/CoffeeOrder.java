package io.hyman.spring.waiterservice.model;

import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @Description:
 * @author: Hyman
 * @date: 2019/07/22 20:27
 * @version： 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoffeeOrder extends BaseEntity implements Serializable {
    private String customer;
    private List<Coffee> items;
    private OrderState state;
}
