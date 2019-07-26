package io.hyman.spring.waiterservice.model;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

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
public class Coffee extends BaseEntity implements Serializable {

    private String name;

    private BigDecimal price;

}
