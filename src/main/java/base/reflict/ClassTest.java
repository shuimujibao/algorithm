package base.reflict;

import java.lang.reflect.Field;

/**
 * @author sunxiaoyu3
 * @description 反射
 * @createTime 2020/10/28 17:40:00
 */
public class ClassTest {
    private static int[] array = new int[3];
    private static int length = array.length;

    private static Class<One> one = One.class;
    private static Class<Another> another = Another.class;


    public static void main(String[] args) throws Exception {
        One oneObject = one.newInstance();
        oneObject.call();

        Another anotherObject = another.newInstance();
        anotherObject.speak();

        Field inner = one.getDeclaredField("inner");
        inner.setAccessible(true);
        inner.set(oneObject,"world");
        System.out.println(oneObject.inner);
    }

    class One {
        private String inner = "time files.";

        public void call() {
            System.out.println("hello world.");
        }

    }

    class Another {
        public void speak() {
            System.out.println("easy coding.");
        }
    }
}
