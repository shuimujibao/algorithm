package base.reflict;

public class Student2 {
    public void show1(String s) {
        System.out.println("调用了：共有的，String参数的show()1: s = " + s);
    }

    protected void show2() {
        System.out.println("调用了受保护的无参的show2（）");
    }

    void show3() {
        System.out.println("调用了：默认的，无参的shou3（）");
    }

    private String show4(int age) {
        System.out.println("调用了，私有的，并且有返回值的，int参数的show4():age = " + age);
        return "abcd";
    }
}
