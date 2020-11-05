package  designpatterns.create.factory.factoryMethod;


import designpatterns.product.Fruit;
import designpatterns.product.fruit.Apple;

public class AppleFactory implements FruitFactory {
    @Override
    public Fruit getFruit() {
        return new Apple();
    }
}
