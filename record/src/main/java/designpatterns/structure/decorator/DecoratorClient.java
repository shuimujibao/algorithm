package designpatterns.structure.decorator;

import designpatterns.create.factory.abstractFactory.AbstractFactory;
import designpatterns.create.factory.abstractFactory.OrangeFactory;
import designpatterns.product.Bag;
import designpatterns.product.Fruit;

import java.util.concurrent.Executors;

/**
 * @author : itw_sunxy
 * @title 设计模式之装饰器模式
 * @description
 * @createtime : 2019/7/2 19:39
 */
public class DecoratorClient {
    public static void main(String[] args) {
        sendFrut();
        Executors.newCachedThreadPool();
    }

    private static void sendFrut() {

        AbstractFactory factory = new OrangeFactory();
        //得到水果
        Fruit fruit = factory.getFruit();
        fruit.draw();
        //得到包装
        Bag bag = factory.getBag();

        //增加防伪标识
        bag = new ReinforceBagDecorator(bag);
        bag = new CheckedBagDecorator(bag);
        bag = new SpeedDecorator(bag);

        bag.pack();

    }
}
