package com.sun.order.repository;

import com.sun.order.bean.OrderCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author sunxiaoyu3
 * @description 商品
 * @createTime 2020/11/05 19:18:00
 */
public interface OrderCategoryRepository extends JpaRepository<OrderCategory, Integer> {
    /**
     * 通过类别编号查询
     *
     * @param orderType 类别编号查询
     * @return OrderCategory
     */
    OrderCategory findByOrderType(Integer orderType);

    /**
     * 通过类别id查询
     *
     * @param orderId id
     * @return OrderCategory
     */
    OrderCategory findByOrderId(Integer orderId);

    /**
     * 通过类别编号范围得到列表
     *
     * @param orderTypes 类别编号范围
     * @return List<OrderCategory>
     */
    List<OrderCategory> findByOrderTypeIn(List<Integer> orderTypes);

}
