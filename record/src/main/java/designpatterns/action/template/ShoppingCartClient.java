package  designpatterns.action.template;

import designpatterns.action.strategy.Discount;
import designpatterns.action.strategy.FullDiscount;
import designpatterns.action.strategy.NewerDiscount;
import designpatterns.action.strategy.SecondDiscount;
import designpatterns.create.factory.simple.StaticFactory;
import designpatterns.product.Fruit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCartClient {
    public static Map<String, Discount> discounts = new HashMap<>();

    static {
        discounts.put("FULL", new FullDiscount());
        discounts.put("SECOND", new SecondDiscount());
        discounts.put("NEWER", new NewerDiscount());
    }

    public static void main(String[] args) {
        List<Fruit> products = new ArrayList<>();
        products.add(StaticFactory.getFruitApple());
        products.add(StaticFactory.getFruitBanana());
        products.add(StaticFactory.getFruitOrange());

        ShoppingCart cart = new CartShoping(products);
        String discount = "FULL";
        cart.setDiscount(discounts.get(discount));
        cart.submitOrder();
    }
}
