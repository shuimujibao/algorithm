package  designpatterns.create.factory.factoryMethod;


import designpatterns.product.Fruit;
import designpatterns.product.fruit.Banana;

public class BananaFactory implements FruitFactory {
    @Override
    public Fruit getFruit() {
        return new Banana();
    }
}
