package com.sun.product.service;

import com.sun.product.bean.ProductCategory;

/**
 * @author sunxiaoyu3
 * @description 商品
 * @createTime 2020/11/05 19:49:00
 */
public interface ProductService {
    /**
     * 通过编号查询
     *
     * @param categoryId 编号查询
     * @return ProductCategory
     */
    ProductCategory findByCategoryType(Integer categoryId);
}
