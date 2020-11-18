package interview.wuba;

import util.node.ListNode;
import util.node.MyLink;

import java.util.Stack;

/**
 * @author sunxiaoyu3
 * @description 反转单链表
 * @createTime 2020/08/28 16:14:00
 */
public class Question {
    public static void main(String[] args) {
        MyLink myLink = new MyLink();
        myLink.addNode(0);
        myLink.addNode(1);
        myLink.addNode(2);
        myLink.addNode(3);
        myLink.addNode(4);
        myLink.addNode(5);

        ListNode root = myLink.getHead();
        MyLink.printNodeList(root);

        revertLinkOne(root);

        MyLink.printNodeList(root);

    }

    public static ListNode revertLink(ListNode root) {
        Stack<ListNode> nodeList = new Stack<>();
        ListNode temp = root;
        while (temp != null) {
            nodeList.add(temp);
            temp = temp.getNext();
        }
        MyLink myLink = new MyLink();
        while (!nodeList.empty()) {
            ListNode node = nodeList.pop();
            myLink.addNode(node.getNode());
        }
        return myLink.getHead();
    }

    private static ListNode revertLinkOne(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode pre = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }


}
