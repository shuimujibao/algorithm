package designpatterns.structure.adapter;

import designpatterns.product.bag.AppleBag;
import designpatterns.product.bag.OrangeBag;
import designpatterns.product.fruit.Orange;

/**
 * @author : itw_sunxy
 * @title 设计模式之适配器模式
 * @description
 * @createtime : 2019/7/2 19:30
 */
public class AdapterClient {
    public static void main(String[] args) {
        Orange orange = new Orange();
        OrangeBag bag = getBag2();
        bag.pack();
    }

    private static OrangeBag getBag() {
        OrangeBag bag = new OrangeBag();
        return bag;
    }


    private static OrangeBag getBag2() {
        AppleBag appleBag = new AppleBag();
        OrangeBag orangeBag = new OrangeBagAdapter(appleBag);
        return orangeBag;
    }
}
