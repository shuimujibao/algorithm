package leetcode.editor.cn;

//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。 
//
// 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/ 
// Related Topics 链表 
// 👍 159 👎 0

import util.node.LinkedList;

public class FanZhuanLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new FanZhuanLianBiaoLcof().new Solution();

        LinkedList myLink = new LinkedList();
        myLink.addNode(1);
        myLink.addNode(2);
        myLink.addNode(3);
        myLink.addNode(4);
        myLink.addNode(5);
        ListNode root = myLink.getHead();
        LinkedList.printNodeList(root);
        ListNode result = solution.reverseList(root);
        LinkedList.printNodeList(result);

    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                System.out.println("最后一个节点：" + (head == null ? null : head.val));
                return head;
            }
            ListNode newHead = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}