package leetcode.editor.cn;

//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1309 👎 0

public class ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();

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

            if (head == null)
                return null;
            ListNode preListNode = null;
            ListNode nowListNode = head;


            while (nowListNode != null) {
                ListNode nextListNode = nowListNode.next;   //保存下一个结点
                nowListNode.next = preListNode;             //当前结点指向前一个结点
                preListNode = nowListNode;                  //前任结点 到现任节点
                nowListNode = nextListNode;                    //现任节点到下一结点
            }
            return preListNode;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}