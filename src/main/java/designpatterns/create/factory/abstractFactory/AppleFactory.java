package designpatterns.create.factory.abstractFactory;


import designpatterns.product.Bag;
import designpatterns.product.Fruit;
import designpatterns.product.bag.AppleBag;
import designpatterns.product.fruit.Apple;

public class AppleFactory implements AbstractFactory {
    @Override
    public Fruit getFruit() {
        return new Apple();
    }

    @Override
    public Bag getBag() {
        return new AppleBag();
    }
}
