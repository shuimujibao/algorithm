package  designpatterns.product.bag;

import designpatterns.product.Bag;

public class BananaBag implements Bag {

    @Override
    public void pack() {
        System.out.println("香蕉包装");
    }
}
