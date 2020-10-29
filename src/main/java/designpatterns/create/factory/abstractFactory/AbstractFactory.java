package designpatterns.create.factory.abstractFactory;


import designpatterns.product.Bag;
import designpatterns.product.Fruit;

public interface AbstractFactory {
    Fruit getFruit();

    Bag getBag();
}
