package base.tree;

import util.node.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sunxiaoyu3
 * @description <p>深度优先遍历（Depth First Search），简称DFS¬</p>
 * 其原则是，沿着一条路径一直找到最深的那个节点，当没有子节点的时候，返回上一级节点，
 * 寻找其另外的子节点，继续向下遍历，没有就向上返回一级，直到所有的节点都
 * 被遍历到，每个节点只能访问一次。
 * @createTime 2020/08/24 14:13:00
 */
public class DepthFirstSearch {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> lists = new ArrayList<>();
        if (root == null)
            return lists;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode tree = queue.poll();
            if (tree.leftNode != null)
                queue.offer(tree.leftNode);
            if (tree.rightNode != null)
                queue.offer(tree.rightNode);
            lists.add(tree.data);
        }
        return lists;
    }
}
