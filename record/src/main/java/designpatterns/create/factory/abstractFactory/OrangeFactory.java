package  designpatterns.create.factory.abstractFactory;


import designpatterns.product.Bag;
import designpatterns.product.Fruit;
import designpatterns.product.bag.OrangeBag;
import designpatterns.product.fruit.Orange;

public class OrangeFactory implements AbstractFactory {
    @Override
    public Fruit getFruit() {

        return new Orange("孙晓宇", 90);
    }

    @Override
    public Bag getBag() {

        return new OrangeBag();
    }
}
