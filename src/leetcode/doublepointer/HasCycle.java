package leetcode.doublepointer;

import util.node.ListNode;

/**
 * @auther: sunxiaoyu
 * @date: 2020-08-05 16:33
 * @description:判断链表是否存在环
 */
public class HasCycle {

    public static void main(String[] args) {
        ListNode root = new ListNode(0);

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        root.add(node1);
        node1.add(node2);
        node2.add(node3);
        node3.add(node4);
        node4.add(node5);
        node5.add(node3);

        //输出带环链表
        int i = 0;
        while (root != null) {
            System.out.println("-->" + root.getNode());
            root = root.getNext();
            i++;
            if (i > 6) {
                break;
            }
        }

        System.out.println("当前链表是否有环：" + hasCycle(root));

    }


    /**
     * 使用双指针，一个指针每次移动一个节点，一个指针每次移动两个节点，如果存在环，那么这两个指针一定会相遇
     *
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode low = head;
        ListNode high = head.next;

        while (low != null && high != null && high.next != null) {
            if (low == high) {
                return true;
            }
            low = low.next;
            high = high.next.next;
        }
        return false;
    }
}
