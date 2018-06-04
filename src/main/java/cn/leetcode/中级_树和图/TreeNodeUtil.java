package cn.leetcode.中级_树和图;

/**
 * Created by Laura on 2018/5/28.
 */
public class TreeNodeUtil {

    public static TreeNode createTree(){
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

        return node4;
    }
}
