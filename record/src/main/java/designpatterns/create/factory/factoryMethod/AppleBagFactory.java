package  designpatterns.create.factory.factoryMethod;


import designpatterns.product.Bag;
import designpatterns.product.bag.AppleBag;

public class AppleBagFactory implements BagFactory {
    @Override
    public Bag getBag() {
        return new AppleBag();
    }
}
