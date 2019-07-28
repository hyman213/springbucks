package io.hyman.spring.waiterservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description:
 * @author: Hyman
 * @date: 2019/07/22 20:27
 * @version： 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoffeeOrder implements Serializable {
    private long orderid;
    private long itemid;
}
