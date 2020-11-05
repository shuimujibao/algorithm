package base.reflict;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("fanshe.Student3");
        Method m = clazz.getMethod("main", String[].class);
        m.invoke(null, (Object) new String[]{"a", "b"});
    }
}
