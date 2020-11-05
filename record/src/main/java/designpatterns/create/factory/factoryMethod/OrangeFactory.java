package  designpatterns.create.factory.factoryMethod;


import designpatterns.product.Fruit;
import designpatterns.product.fruit.Orange;

public class OrangeFactory implements FruitFactory {
    @Override
    public Fruit getFruit() {
        return new Orange();
    }
}
