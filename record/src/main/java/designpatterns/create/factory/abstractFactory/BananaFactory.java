package  designpatterns.create.factory.abstractFactory;


import designpatterns.product.Bag;
import designpatterns.product.Fruit;
import designpatterns.product.bag.BananaBag;
import designpatterns.product.fruit.Banana;

public class BananaFactory implements AbstractFactory {
    @Override
    public Fruit getFruit() {
        return new Banana();
    }

    @Override
    public Bag getBag() {
        return new BananaBag();
    }
}
