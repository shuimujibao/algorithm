package com.sun.order.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

/**
 * @author sunxiaoyu3
 * @description 商品试题类
 * @createTime 2020/11/05 19:13:00
 */
@Data
@Entity
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
public class OrderCategory {
    /**
     * 类别id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    /**
     * 类别名称
     */
    @Column(name = "order_name")
    private String orderName;

    /**
     * 类别编号
     */
    @Column(name = "order_type")
    private Integer categoryType;


}
