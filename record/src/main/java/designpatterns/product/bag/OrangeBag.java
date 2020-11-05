package  designpatterns.product.bag;

import designpatterns.product.Bag;

public class OrangeBag implements Bag {

    @Override
    public void pack() {
        System.out.println("橘子包装");
    }
}
