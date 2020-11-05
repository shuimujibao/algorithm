package leetcode.doublepointer;

import util.node.ListNode;

/**
 * @auther: tal
 * @date: 2020-08-05 17:06
 * @description:
 */
public class LinkList001 {
    static ListNode head;

    public static void main(String[] args) {
        init();
        add(getNode(6));// 这里面去第7个
        print();
    }

    /**
     * 链表初始化
     */
    public static void init() {
        for (int i = 0; i < 10; i++) {
            add(new ListNode(i, null));
        }
    }

    /**
     * 为了生成环需要取到环节点的指针
     *
     * @param i
     * @return
     */
    public static ListNode getNode(int i) {
        int count = 0;
        ListNode temp = head;
        while (temp.next != null) {
            if (count == i) {
                //return temp;
                break;
            }
            temp = temp.next;
            count++;
        }
        return temp;
    }

    /**
     * 链表的添加
     *
     * @param node
     */
    public static void add(ListNode node) {
        ListNode temp = head;

        if (head == null) {
            head = node;
            return;
        }

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    /**
     * 打印链表
     * 因为有环所以只循环了20次
     * 实际上是无限循环的
     */
    public static void print() {
        StringBuffer buff = new StringBuffer();

        ListNode temp = head;

        buff.append(temp.node);

        int count = 0;

        while (temp.next != null) {
            buff.append("->");
            temp = temp.next;
            buff.append(temp.node);
            System.out.println(buff.toString());

            count++;

            if (count == 20) {
                break;
            }
        }
    }

    /**
     * 判断链表是否有环
     *
     * @param node
     * @return
     */
    public static boolean isLinkedCycle(ListNode node) {

        if (node == null) {
            return false;
        }

        ListNode fast = node;
        ListNode slow = node;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

}
