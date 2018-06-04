package cn.leetcode.中级_树和图;

import cn.leetcode.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Laura on 2018/5/27.
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 *      1
 *    /   \
 * null    2
 *        /
 *      3
 * <p>
 * 输出: [1,3,2]
 * <p>
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class 中序遍历二叉树 {

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

        List<Integer> result = inorderTraversal(node1);
        print(result);
    }

    /**
     * 递归写法
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal( TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        inOrderRec(list, root);
        return list;
    }

    public static void inOrderRec(List<Integer> list, TreeNode root){
       if(root != null){
           inOrderRec(list, root.left);
           list.add(root.val);
           inOrderRec(list, root.right);
       }

    }

    /**
     * 非递归
     * @param
     */
    public static List<Integer> inorder( TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;

        Stack<TreeNode> s = new Stack<>();
        while(root != null || !s.isEmpty()){
            while(root != null){
                s.push(root);
                root = root.left;
            }
            if(!s.empty()) {
                root = s.pop();
                list.add(root.val);
                root = root.right;
            }
        }


        return list;
    }


    public static void print(List<Integer> res){
        System.out.println("[ ");
        for (Integer t : res) {
            System.out.print(t + " ");
        }
        System.out.println(" ]");
    }
}
