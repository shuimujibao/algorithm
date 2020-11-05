package designpatterns.create.factory.factoryMethod;


import designpatterns.product.Bag;
import designpatterns.product.Fruit;

public class FactoryTest {
    public static FruitFactory fruitFactory;
    public static BagFactory bagFactory;

    public static void main(String[] args) {
        fruitFactory = new BananaFactory();
        bagFactory = new BananaBagFactory();
        peterdo();
    }

    private static void peterdo() {
        Fruit fruit = fruitFactory.getFruit();
        fruit.draw();

        Bag bag = bagFactory.getBag();
        bag.pack();

    }
}
