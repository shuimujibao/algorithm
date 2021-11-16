package example.example1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * MainTest
 *
 * @summary MainTest
 * @author: sunxiaoyu016
 * @Copyright (c) 2021, © 贝壳找房（北京）科技有限公司
 * @since: 2021年11月05日 11:50:00
 */
public class MainTest {

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        Apple apple = new Apple();

        filterApples(inventory, Apple::isGreenApple);
        filterApples(inventory, Apple::isHeavyApple);
    }


    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        //result是用来累积结果的List，开始为空，然后一个个加入绿苹果
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            //高亮显示的代码会仅仅选出绿苹果
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterHeavyApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }


    static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

}
