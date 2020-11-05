package base.reflict;

import java.lang.reflect.Constructor;

public class Constructors {
    public static void main(String[] args) throws Exception {
        //加载Class对象
        Class clazz = Class.forName("fanshe.Student");

        //获取所有共有构造方法
        System.out.println("********************所有公有的构造方法*********************");
        Constructor[] conArray = clazz.getConstructors();
        for (Constructor c :
                conArray) {
            System.out.println(c);
        }

        System.out.println("******************获取所有的构造方法（包括：共有、私有、受保护、默认）*************");
        conArray = clazz.getDeclaredConstructors();
        for (Constructor c :
                conArray) {
            System.out.println(c);
        }

        System.out.println("*****************获取公有、无参的构造方法**************************");
        Constructor con = clazz.getConstructor(null);
        System.out.println("con = " + con);
        //调用构造方法
        Object obj = con.newInstance();

        System.out.println("***************获取私有构造方法,并调用*********************");
        con = clazz.getDeclaredConstructor(char.class);
        System.out.println(con);

        //调用构造方法
        con.setAccessible(true);
        obj = con.newInstance('男');
    }
}
