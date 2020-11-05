package base.reflict;

public class StudentEg {
    public StudentEg() {

    }

    public String name;
    public int age;
    char sex;
    private String phoneNum;

    @Override
    public String toString() {
        return "StudentEg{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }
}
