package util.node;

/**
 * @author sunxiaoyu3
 * @description 二叉树数据结构
 * @createTime 2020/08/24 14:16:00
 */
public class TreeNode {
    public int data;
    public TreeNode leftNode;
    public TreeNode rightNode;

    public TreeNode() {

    }

    public TreeNode(int d) {
        data = d;
    }

    public TreeNode(TreeNode left, TreeNode right, int d) {
        leftNode = left;
        rightNode = right;
        data = d;
    }

}
