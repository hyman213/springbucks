package io.hyman.spring.waiterservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:
 * @author: Hyman
 * @date: 2019/07/22 18:07
 * @version： 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity implements Serializable {

    // 注意不要导错包：javax.persistence.Id
    private Long id;

    private Date createTime;

    private Date updateTime;

}
