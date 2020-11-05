package com.sun.product.service.impl;

import com.sun.product.bean.ProductCategory;
import com.sun.product.repository.ProductCategoryRepository;
import com.sun.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sunxiaoyu3
 * @description 商品
 * @createTime 2020/11/05 19:50:00
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Override
    public ProductCategory findByCategoryType(Integer categoryId) {
        return productCategoryRepository.getOne(categoryId);
    }
}
