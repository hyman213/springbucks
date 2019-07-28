package io.hyman.spring.waiterservice.model;

import lombok.*;

import java.io.Serializable;

/**
 * @Description:
 * @author: Hyman
 * @date: 2019/07/22 18:16
 * @version： 1.0.0
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Order extends BaseEntity implements Serializable {

    private String customer;

    private OrderState state;
}
