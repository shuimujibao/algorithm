package designpatterns.service.impl;

import designpatterns.service.OrderService;

/**
 * @author : itw_sunxy
 * @description 本地订单
 * @createtime : 2019/6/26 19:02
 */
public class OrderServiceImpl implements OrderService {
    @Override
    public int saveOrder() {
        System.out.println("下单成功，订单号：888888");
        return 888888;
    }
}
