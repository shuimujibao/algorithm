package leetcode.editor.cn;

//编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。 
//
// 示例1: 
//
// 
// 输入：[1, 2, 3, 3, 2, 1]
// 输出：[1, 2, 3]
// 
//
// 示例2: 
//
// 
// 输入：[1, 1, 1, 1, 2]
// 输出：[1, 2]
// 
//
// 提示： 
//
// 
// 链表长度在[0, 20000]范围内。 
// 链表元素在[0, 20000]范围内。 
// 
//
// 进阶： 
//
// 如果不得使用临时缓冲区，该怎么解决？ 
// Related Topics 哈希表 链表 双指针 
// 👍 129 👎 0

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateNodeLcci {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicateNodeLcci().new Solution();

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
        public ListNode removeDuplicateNodes(ListNode head) {

            // 链表为空或只有一个节点直接返回
            if (head == null || head.next == null) {
                return head;
            }

            // 利用HashSet特性判断链表中的重复值
            Set<Integer> set = new HashSet<>();

            // 当前节点
            ListNode curNode = head;

            // 当前链表
            ListNode node = head;

            set.add(curNode.val);

            while (curNode != null) {
                if (set.add(curNode.val)) {
                    // 当前节点未有重复值
                    node.next = curNode;
                    node = node.next;
                }

                curNode = curNode.next;
            }

            node.next = null;

            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}