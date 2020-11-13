package com.sun.product.feign.producer;

import com.sun.product.service.ProductService;
import dto.ProductDto;
import framework.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sunxiaoyu3
 * @description 对外提供商品服务
 * @createTime 2020/11/13 09:26:00
 */

@RestController
@Slf4j
public class ProductProducer {

    @Resource
    ProductService productService;

    @ResponseBody
    @RequestMapping("/findByCategoryType")
    public ResponseEntity batchExportPdf(@RequestBody ProductDto productDto) {
        try {
            return new ResponseEntity<>(Result.buildSuccessResult(productService.findByCategoryType(productDto.getCategoryId()), "获取商品种类信息成功."), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }
}
