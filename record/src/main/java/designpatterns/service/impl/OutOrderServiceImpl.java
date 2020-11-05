package designpatterns.service.impl;

import designpatterns.service.OrderService;

/**
 * @author : itw_sunxy
 * @description 海外订单
 * @createtime : 2019/6/26 19:03
 */
public class OutOrderServiceImpl implements OrderService {
    @Override
    public int saveOrder() {
        System.out.println("下单成功，订单号：66666666");
        return 66666666;
    }
}
