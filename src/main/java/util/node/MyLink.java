package util.node;

/**
 * @author sunxiaoyu3
 * @description TODO
 * @createTime 2020/08/28 17:50:00
 */
public class MyLink {

    /**
     * 链表头节点
     */
    ListNode head;

    /**
     * 初始化链表
     *
     * @param root
     */
    public MyLink(ListNode root) {
        this.head = root;
    }

    public MyLink() {
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
