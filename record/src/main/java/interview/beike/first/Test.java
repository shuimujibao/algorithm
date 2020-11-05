package interview.beike.first;

/**
 * @author sunxiaoyu3
 * @description TODO
 * @createTime 2020/09/27 14:28:00
 */

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader questionClassLoader = Question.class.getClassLoader();
        System.out.println(questionClassLoader);
        FatherQuestion fatherQuestion = (FatherQuestion) questionClassLoader.loadClass("interview.beike.first.FatherQuestion").newInstance();
        System.out.println(fatherQuestion);
    }
}
