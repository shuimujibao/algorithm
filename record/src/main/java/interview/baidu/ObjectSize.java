package interview.baidu;

import java.lang.instrument.Instrumentation;

/**
 * @author sunxiaoyu3
 * @description 获取运行期间对象占用内存大小
 * @createTime 2020/12/18 11:00:00
 */
public class ObjectSize {
    private static volatile Instrumentation instru;

    public static void premain(String args, Instrumentation inst) {
        instru = inst;
    }

    public static Long getSizeOf(Object object) {
        if (instru == null) {
            throw new IllegalStateException("Instrumentation is null");
        }
        return instru.getObjectSize(object);
    }
}
