与统计数字的次数的题目大同小异，只是变成了统计char的个数而言。
这里大小写是不同的，一定要记住。

思路: 
1. 我们要创建一个map来存每个char及其次数。
2. 创建maxheap，因为我们要保证堆顶char次数是最大的。
3. 要创建一个stringbuilder（不要创建string，可以自己比较一下）去存储结果。
4. 弹出堆顶，按照其统计次数，建立循环，加入char到结果中，重复以上步骤。
5. 输出结果即可。


```
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char chr : s.toCharArray()) {
            map.put(chr, map.getOrDefault(chr, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
            (e1, e2) -> e2.getValue() - e1.getValue());

        maxHeap.addAll(map.entrySet());

        StringBuilder sortedString = new StringBuilder(s.length());
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            for (int i = 0; i < entry.getValue(); i++){
                sortedString.append(entry.getKey());
            }
        }
        return sortedString.toString();
    }
}
```
time: worst case，因为没有重复元素，每一个都是唯一的，那么**O(n) = n * log(n)**。
space: 因为要在map中存n个元素，所以所使用的额外空间就是**O(n) = n**

# ***"Top" k 题型总结ing：***
["Top" k - 1: leetcode 215](https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/java-top-k-1-by-donoghl-2/)
["Top" k - 2: 面试题17.14](https://leetcode-cn.com/problems/smallest-k-lcci/solution/java-top-k-2-by-donoghl/)
["Top" k - 3: leetcode 973](https://leetcode-cn.com/problems/k-closest-points-to-origin/solution/java-top-k-3-by-donoghl/)
["Top" k - 4: leetcode 1167](https://leetcode-cn.com/problems/minimum-cost-to-connect-sticks/solution/java-top-k-4-by-donoghl/)
["Top" k - 5: leetcode 347](https://leetcode-cn.com/problems/top-k-frequent-elements/solution/java-top-k-5-by-donoghl/)
