package util.node;

/**
 * @auther: sunxiaoyu
 * @date: 2020-08-05 16:34
 * @description: 链表
 */
public class ListNode {

    public int node;
    public ListNode next;

    public ListNode(int node, ListNode next) {
        this.node = node;
        this.next = next;
    }

    public ListNode(int node) {
        this.node = node;
    }

    public ListNode() {
    }

    /**
     * @param node
     */
    public void add(ListNode node) {
        if (next == null) {
            this.next = node;
        }
        if (next != null) {
            next = next.getNext();
        }
        next = node;
    }

    /**
     * 获取当前结点的值
     *
     * @return
     */
    public int getNode() {
        return node;
    }

    /**
     * 获取当前结点的下一个结点
     *
     * @return
     */
    public ListNode getNext() {
        return next;
    }
}
