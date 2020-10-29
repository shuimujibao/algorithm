package designpatterns.create.factory.abstractFactory;


import designpatterns.product.Bag;
import designpatterns.product.Fruit;

public class OrderSendClient {
    public static void main(String[] args) {
        sendFruit();
    }

    private static void sendFruit() {
        AbstractFactory factory = new BananaFactory();

        Fruit fruit = factory.getFruit();
        Bag bag = factory.getBag();
        bag.pack();
    }
}
