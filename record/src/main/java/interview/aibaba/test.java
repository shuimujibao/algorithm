package interview.aibaba;


import lombok.Data;

/**
 * @author sunxiaoyu3
 * @description TODO
 * @createTime 2020/12/10 18:16:00
 */
public class test {
    @Data
    static class Bean {
        int a;
    }

    public static void main(String[] args) {
        Bean bean = new Bean();
        bean.setA(5);
        add(bean);
        System.out.println(bean.toString());
    }

    private static void add(Bean bean) {
        bean.setA(bean.getA() + 1);
    }
}
