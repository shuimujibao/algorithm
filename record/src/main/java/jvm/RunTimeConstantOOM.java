package  jvm;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sunxiaoyu3
 * @description 运行时常量池导致内存溢出
 * @createTime 2020/09/18 11:08:00
 * <p>
 * VM Args ：
 * -XX:PermSize=6M -XX:MaxPermSize=6M JDK1.7
 * -XX:MaxMeta-spaceSize JDK8
 */
public class RunTimeConstantOOM {
    /**
     * String::intern()是一个本地方法，它的作用是如果字符串常量池中包含一个等于此String对象的字符串，则返回池中这个字符串的String对象的引用；
     * 否则，会将此String对象包含的字符串添加到常量池
     *
     * @param args
     */
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        short i = 0;
        while (true) {
            set.add(String.valueOf(i++).intern());
        }
    }
}
