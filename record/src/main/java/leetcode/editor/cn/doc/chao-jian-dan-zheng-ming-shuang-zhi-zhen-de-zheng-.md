设链表A的长度为a，链表B的长度为b，A到相交结点的距离为c,B到相交节点的距离为d，显然可以得到两者相交链表的长度：`a - c = b - d`， 变换一下式子得到:`a + d = b + c`
我们用一个指针从链表A出发，到末尾后就从B出发，用另一个指针从B出发，到末尾后从A出发，由于上面的公式，当前一个指针走了a+d步数时，后一个指针走了b+c,两步数相等，即走到了相交节点。
```java
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode t1 = headA;
        ListNode t2 = headB;
        while(t1 != t2){
            t1 = t1 != null ? t1.next : headB;
            t2 = t2 != null ? t2.next : headA;
        }
        return t2;
    }
}
```