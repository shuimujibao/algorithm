package  designpatterns.create.factory.factoryMethod;


import designpatterns.product.Bag;
import designpatterns.product.bag.OrangeBag;

public class OrangeBagFactory implements BagFactory {

    @Override
    public Bag getBag() {
        return new OrangeBag();
    }
}
