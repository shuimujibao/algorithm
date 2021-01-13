package util.node;

import leetcode.editor.cn.ListNode;

/**
 * @author sunxiaoyu3
 * @description 链表
 * @createTime 2021/01/13 15:14:00
 */
public class LinkedList {
    /**
     * 链表头节点
     */
    ListNode head;

    /**
     * 初始化链表
     *
     * @param root
     */
    public LinkedList(ListNode root) {
        this.head = root;
    }

    public LinkedList() {
    }

    /**
     * 获取头节点
     *
     * @return
     */
    public ListNode getHead() {
        return this.head;
    }

    /**
     * 向链表中插入值
     *
     * @param d
     */
    public void addNode(int d) {
        ListNode newNode = new ListNode(d);// 实例化一个节点
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = newNode;
    }

    /**
     * 输出单链表
     *
     * @param root
     */
    public static void printNodeList(ListNode root) {
        ListNode next = root;
        String flag = null;
        while (next != null) {
            flag = next.getNext() == null ? "\t" : "->";
            System.out.print(next.getNode() + flag);
            next = next.getNext();
        }
    }

}
