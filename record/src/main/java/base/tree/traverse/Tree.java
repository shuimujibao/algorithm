package base.tree.traverse;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author sunxiaoyu3
 * @description 二叉树定义
 * @createTime 2020/10/29 10:07:00
 */
public class Tree {
    int data;
    Tree left;
    Tree right;

    public Tree(int data) {
        this.data = data;
    }

    public static Tree initTree() {
        Tree node1 = new Tree(1);
        Tree node2 = new Tree(2);
        Tree node3 = new Tree(3);
        Tree node4 = new Tree(4);
        Tree node5 = new Tree(5);
        Tree node6 = new Tree(6);
        Tree node7 = new Tree(7);
        Tree node8 = new Tree(8);
        Tree node9 = new Tree(9);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.right = node8;
        node7.left = node9;
        return node1;
    }

    public static void deepFirstSearch(Tree tree) {
        Stack<Tree> stack = new Stack<>();
        stack.push(tree);

        while (!stack.isEmpty()) {
            Tree node = stack.pop();
            System.out.print(node.data + " ");

            // stack先进后出，所以先右后左
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        System.out.println();

    }

    public static void broadFirstSearch(Tree tree) {
        Queue<Tree> queue = new LinkedList<>();
        queue.add(tree);

        while (!queue.isEmpty()) {
            Tree node = queue.poll();
            System.out.print(node.data + " ");

            // queue先进先出，所以先左后右
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Tree tree = Tree.initTree();

        Tree.deepFirstSearch(tree);

        Tree.broadFirstSearch(tree);
    }
}
