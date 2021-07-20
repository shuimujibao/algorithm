package leetcode.editor.cn;

//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 栈 递归 链表 双指针 
// 👍 1049 👎 0

public class PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public boolean isPalindrome(ListNode head) {
            //当前节点为null 或者只有一个节点 肯定为回文
            if (head == null || head.next == null) {
                return true;
            }

            //使用双指针，快的比慢的多走一步，获取中间位置
            ListNode slow = head;
            ListNode quick = head;

            while (quick != null && quick.next != null) {
                quick = quick.next.next;
                slow = slow.next;
            }

            //此时slow为链表后半段，反转slow
            ListNode pre = null;
            ListNode p = slow;

            while (p != null) {
                ListNode temp = p.next;
                p.next = pre;
                pre = p;
                p = temp;
            }

            //对比前半段和后半段的data值是否相同
            while (pre != null) {
                if (pre.val == head.val) {
                    pre = pre.next;
                    head = head.next;
                } else {
                    return false;
                }
            }
            //返回true
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}