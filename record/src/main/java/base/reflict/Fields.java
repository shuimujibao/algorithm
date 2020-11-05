package base.reflict;

import java.lang.reflect.Field;

public class Fields {
    public static void main(String[] args) throws Exception {
        //获取class对象
        Class stuClass = Class.forName("fanshe.StudentEg");
        //获取字段
        System.out.println("***************获取所有共有的字段*****************");
        Field[] fieldArray = stuClass.getFields();
        for (Field f :
                fieldArray) {
            System.out.println(f);
        }
        System.out.println("***************获取所有的字段（包括私有，受保护，默认的）********************");
        fieldArray = stuClass.getDeclaredFields();
        for (Field f :
                fieldArray) {
            System.out.println(f);
        }
        System.out.println("*********************获取共有字段并调用*****************************************************88");
        Field f = stuClass.getField("name");
        System.out.println(f);
        //获取一个对象
        Object obj = stuClass.getConstructor().newInstance();
        //为字段设置值
        f.set(obj, "刘德华");
        //验证
        StudentEg stu = (StudentEg) obj;
        System.out.println("验证姓名：" + stu.name);

        System.out.println("*************获取私有字段并调用************************");
        f = stuClass.getDeclaredField("phoneNum");
        System.out.println(f);
        f.setAccessible(true); //暴力反射，解除私有限定
        f.set(obj, "188889998882988");
        System.out.println("验证电话：" + stu);
    }
}
