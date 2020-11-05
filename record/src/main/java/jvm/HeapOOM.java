package  jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunxiaoyu3
 * @description java堆内存溢出测试
 * @createTime 2020/09/18 10:22:00
 * VM Args:-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=${/Users/tal} -XX:+PrintGCDetails
 * <p>
 * 查看默认的垃圾回收器 -XX:+PrintCommandLineFlags -version
 */
public class HeapOOM {
    private static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
