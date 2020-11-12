package com.sun.order.service.impl;

import com.sun.order.bean.OrderCategory;
import com.sun.order.repository.OrderCategoryRepository;
import com.sun.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sunxiaoyu3
 * @description 商品
 * @createTime 2020/11/05 19:50:00
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderCategoryRepository orderCategoryRepository;

    @Override
    public OrderCategory findByCategoryType(Integer categoryId) {
        return orderCategoryRepository.getOne(categoryId);
    }
}
