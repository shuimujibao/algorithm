package leetcode.editor.cn;

//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表 
// 👍 75 👎 0

import java.util.Stack;

public class CongWeiDaoTouDaYinLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();

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
        public int[] reversePrint(ListNode head) {
            Stack<ListNode> stack = new Stack<ListNode>();
            ListNode temp = head;
            while (temp != null) {
                stack.push(temp);
                temp = temp.next;
            }
            int size = stack.size();
            int[] print = new int[size];
            for (int i = 0; i < size; i++) {
                print[i] = stack.pop().val;
            }
            return print;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}