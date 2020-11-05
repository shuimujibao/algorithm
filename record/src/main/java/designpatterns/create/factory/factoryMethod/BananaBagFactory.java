package designpatterns.create.factory.factoryMethod;


import designpatterns.product.Bag;
import designpatterns.product.bag.BananaBag;

public class BananaBagFactory implements BagFactory {
    @Override
    public Bag getBag() {
        return new BananaBag();
    }
}
