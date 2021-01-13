package leetcode.editor.cn;

/**
 * @author sunxiaoyu3
 * @description 链表结点
 * @createTime 2020/10/26 11:11:00
 */
public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * 获取当前结点的下一个结点
     *
     * @return ListNode
     */
    public ListNode getNext() {
        return next;
    }

    /**
     * 获取当前结点的值
     *
     * @return int
     */
    public int getNode() {
        return val;
    }
}
