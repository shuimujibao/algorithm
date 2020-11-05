package  leetcode.editor.cn;

/**
 * @author sunxiaoyu3
 * @description 链表结点
 * @createTime 2020/10/26 11:11:00
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
