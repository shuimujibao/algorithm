package com.sun.order.controller;

import com.sun.order.feign.consumer.ProductConsumer;
import com.sun.order.service.OrderService;
import dto.OrderDto;
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
 * @description 订单
 * @createTime 2020/11/05 19:45:00
 */
@RestController
@RequestMapping("order")
@Slf4j
public class OrderController {

    @Resource
    OrderService productService;

    @Resource
    ProductConsumer productConsumer;

    @ResponseBody
    @RequestMapping("/findByOrderId")
    public ResponseEntity findByOrderId(@RequestBody OrderDto orderDto) {
        try {
            return new ResponseEntity<>(Result.buildSuccessResult(productService.findByCategoryType(orderDto.getOrderId()), "获取订单信息成功."), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @ResponseBody
    @RequestMapping("/buy")
    public ResponseEntity buy(@RequestBody OrderDto orderDto) {
        try {
            ProductDto productDto = new ProductDto();
            productDto.setCategoryId(orderDto.getOrderId());
            return new ResponseEntity<>(Result.buildSuccessResult(productConsumer.findByCategoryType(productDto), "获取订单信息成功."), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

}
