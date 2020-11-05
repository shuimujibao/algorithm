package jvm;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author sunxiaoyu3
 * @description 使用unsafe类 造成本地直接内存溢出
 * @createTime 2020/10/01 10:51:00
 * <p>
 * VM args: -Xmx10M -XX:MaxDirectMemorySize=10M -XX:HeapDumpPath=${/Users/tal} -XX:+PrintGCDetails
 */
public class DirectMemoryOOM {
    private static final int _1M = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unSafeField = Unsafe.class.getDeclaredFields()[0];
        unSafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unSafeField.get(null);

        while (true) {
            unsafe.allocateMemory(_1M);
        }
    }
}
