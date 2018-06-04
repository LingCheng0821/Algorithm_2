package cn.leetcode.中级_树和图;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Laura on 2018/5/27.
 */
public class 遍历二叉树 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node10 = new TreeNode(10);

        node4.left = node2;
        node2.left = node1;
        node2.right = node3;
        node4.right = node6;
        node6.left = node5;
        node6.right = node7;
        node7.right = node8;
        node8.right = node10;

//        preOrder(node4);
//        preOrder1(node4);
//        midOrder1(node4);
//        posOrder(node4);
//        levelOrder(node4);
        int level = depth(node4);
        levelOrder(node4, level);
    }

    /**
     * 递归
     * 遍历二叉树
     *
     * @param node
     */
    public static void preOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    /**
     * 非递归
     * 遍历二叉树
     *
     * @param node
     */
    public static void preOrder1(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.empty()) {
            while (node != null) {
                System.out.print(node.val + "   ");
                stack.push(node);
                node = node.left;
            }
            if (!stack.empty()) {
                node = stack.pop();
                node = node.right;
            }
        }
    }
    /**
     * 递归
     * 中序遍历
     */
    public static void midOrder(TreeNode node) {
        if (node != null) {
            midOrder(node.left);
            System.out.print(node.val + " ");
            midOrder(node.right);
        }
    }
    /**
     * 非递归
     * 中序遍历
     *
     * @param node
     * @return
     */
    public static void midOrder1(TreeNode node) {
        Stack<TreeNode> s = new Stack<>();

        while (node != null || !s.isEmpty()) {
            while (node != null) {
                s.push(node);
                node = node.left;
            }
            if (!s.empty()) {
                node = s.pop();
                System.out.print(node.val + "   ");
                node = node.right;
            }
        }

    }
    /**
     * 后序遍历
     * 递归
     */
    public static void posOrder(TreeNode node) {
        if (node != null) {
            posOrder(node.left);
            posOrder(node.right);
            System.out.print(node.val + " ");
        }
    }
    /**
     * 后序遍历
     * 非递归
     */
    public static void posOrder1(TreeNode node) {
        TreeNode q = node;
        Stack<TreeNode> s = new Stack<TreeNode>();
        while (node != null) {
            while (node.left != null) {  // 左子树入栈
                s.push(node);
                node = node.left;
            }
            while (node != null && (node.right == null || node.right == q)) {
                System.out.print(node.val + "   ");
                q = node;// 记录上一个已输出节点
                if (s.empty()) return;
                node = s.pop();
            }

            // 处理右子
            s.push(node);
            node = node.right;
        }
    }

    /**
     * 层次遍历
     * 非递归
     */
    public static void levelOrder(TreeNode node) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        if (node == null) return;
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            System.out.print(temp.val + "   ");
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }

    }

    private static void levelOrder(TreeNode node, int level) {
        if (node == null || level < 1) return;
        if (level == 1) {
            System.out.print(node.val + "  ");
            return;
        }
        // 左子树
        levelOrder(node.left, level - 1);
        // 右子树
        levelOrder(node.right, level - 1);
    }

    public static int depth(TreeNode node) {
        if (node == null)  return 0;

        int l = depth(node.left);
        int r = depth(node.right);
        if (l > r)  return l + 1;
        else return r + 1;
    }
}

