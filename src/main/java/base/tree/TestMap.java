package base.tree;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author sunxiaoyu3
 * @description TODO
 * @createTime 2020/10/27 10:59:00
 */
public class TestMap {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("one", 121);
        hashMap.get("one");
        hashMap.size();
        hashMap.getOrDefault(0, 888);
        System.out.println(hash("one"));
        System.out.println(hashMap);

        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("two", 7879);
        concurrentHashMap.get("two");
        concurrentHashMap.size();
        System.out.println(concurrentHashMap);
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

}
