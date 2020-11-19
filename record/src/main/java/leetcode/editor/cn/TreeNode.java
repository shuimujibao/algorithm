package leetcode.editor.cn;

/**
 * @author sunxiaoyu3
 * @description 二叉树
 * @createTime 2020/10/29 10:16:00
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
