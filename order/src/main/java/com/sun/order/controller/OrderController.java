package com.sun.order.controller;

import com.sun.order.dto.OrderDto;
import com.sun.order.service.OrderService;
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
 * @description 商品
 * @createTime 2020/11/05 19:45:00
 */
@RestController
@RequestMapping("product")
@Slf4j
public class OrderController {

    @Resource
    OrderService productService;

    @ResponseBody
    @RequestMapping("/findByCategoryType")
    public ResponseEntity batchExportPdf(@RequestBody OrderDto orderDto) {
        try {
            return new ResponseEntity<>(Result.buildSuccessResult(productService.findByCategoryType(orderDto.getOrderId())), HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

}
