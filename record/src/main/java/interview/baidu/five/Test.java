package interview.baidu.five;

/**
 * @author sunxiaoyu3
 * @description 一个二叉树相距最远的两个节点的距离
 * 1
 * 3      4
 * 6     7
 * 8  9  10  11
 * @createTime 2021/07/08 19:31:00
 */
public class Test {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public Integer getMaxDistance(TreeNode root) {
        int maxDistance = 0;
        return findTree(root, maxDistance);
    }

    private Integer findTree(TreeNode root, int maxDistance) {

        if (root == null) {
            return maxDistance;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        if (left == null && right == null) {
            return maxDistance;
        }

        findTree(root.left, maxDistance + 1);
        findTree(root.right, maxDistance + 1);

        return maxDistance;
    }
}
