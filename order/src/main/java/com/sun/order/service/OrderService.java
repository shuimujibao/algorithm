package com.sun.order.service;

import com.sun.order.bean.OrderCategory;

/**
 * @author sunxiaoyu3
 * @description 订单
 * @createTime 2020/11/05 19:49:00
 */
public interface OrderService {
    /**
     * 通过编号查询
     *
     * @param categoryId 编号查询
     * @return OrderCategory
     */
    OrderCategory findByCategoryType(Integer categoryId);
}
