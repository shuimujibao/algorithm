package com.sun.order.feign.consumer;

import dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sunxiaoyu3
 * @description 商品服务远程调用
 * @createTime 2020/11/13 09:24:00
 */
@FeignClient("product")
public interface ProductConsumer {

    @RequestMapping("/findByCategoryType")
    String findByCategoryType(ProductDto productDto);
}
