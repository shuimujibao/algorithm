package base.reflict;

import java.lang.reflect.Method;

public class MethodClasss {
    public static void main(String[] args) throws Exception {
        //1.获取Class对象
        Class stuClass = Class.forName("fanshe.Student2");
        //2.获取所有的共有方法
        System.out.println("*************获取所有的“共有方法”**********************");
        stuClass.getMethods();
        Method[] methodArray = stuClass.getMethods();
        for (Method m :
                methodArray) {
            System.out.println(m);
        }
        System.out.println("************获取所有方法包括私有的*********************");
        methodArray = stuClass.getDeclaredMethods();
        for (Method m :
                methodArray) {
            System.out.println(m);
        }
        System.out.println("**********获取公有的show()1方法******************8");
        Method m = stuClass.getMethod("show1", String.class);
        System.out.println(m);
        //实例化一个Student对象
        Object obj = stuClass.getConstructor().newInstance();
        m.invoke(obj, "刘德华");
    }
}
