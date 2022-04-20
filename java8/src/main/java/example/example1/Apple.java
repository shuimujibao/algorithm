package example.example1;

/**
 * Apple
 *
 * @summary Apple
 * @author: sunxiaoyu016
 * @Copyright (c) 2021, © 贝壳找房（北京）科技有限公司
 * @since: 2021年11月05日 11:48:00
 */
public class Apple {



    private String color;

    private Integer weight;

    public Apple(String color, Integer weight) {
        this.color = color;
        this.weight = weight;
    }

    public Apple() {

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    public interface Predicate<T> {
        boolean test(T t);
    }
}
