package com.sun.product.repository;

import com.sun.product.bean.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author sunxiaoyu3
 * @description 商品
 * @createTime 2020/11/05 19:18:00
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
    /**
     * 通过类别编号查询
     *
     * @param categoryType 类别编号查询
     * @return ProductCategory
     */
    ProductCategory findByCategoryType(Integer categoryType);

    /**
     * 通过类别id查询
     *
     * @param categoryId id
     * @return ProductCategory
     */
    ProductCategory findByCategoryId(Integer categoryId);

    /**
     * 通过类别编号范围得到列表
     *
     * @param categoryTypes 类别编号范围
     * @return List<ProductCategory>
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypes);

}
