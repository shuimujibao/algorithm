package base.reflict;

public class FanShe {
    public static void main(String[] args) {
        //第一种获取Class对象
        Student stu1 = new Student();//这一new 产生一个Student对象 一个Class对象
        Class stuClass = stu1.getClass();//获取Class对象
        System.out.println(stuClass.getName());

        //第二种方式获取Class对象
        Class stuClass2 = Student.class;
        System.out.println(stuClass2 == stuClass);

        //第三种方式获取Class对象
        try {
            Class stuClass3 = Class.forName("fanshe.Student");
            System.out.println(stuClass3 == stuClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
