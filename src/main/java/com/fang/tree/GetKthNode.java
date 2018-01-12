package com.fang.tree;

/**
 * 给定一颗二叉搜索树，请找出其中的最小的k大的结点。
 * 例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为2,3，4。
 * 解题思路：
 */
public class GetKthNode {
    public static void main(String[] args) {
        TreeNode pRoot5 = new TreeNode(8);
        TreeNode pRoot3 = new TreeNode(6);
        TreeNode pRoot7 = new TreeNode(10);
        TreeNode pRoot2 = new TreeNode(5);
        TreeNode pRoot4 = new TreeNode(7);
        TreeNode pRoot6 = new TreeNode(9);
        TreeNode pRoot8 = new TreeNode(11);
        pRoot5.left = pRoot3;
        pRoot5.right = pRoot7;
        pRoot3.left = pRoot2;
        pRoot3.right = pRoot4;
        pRoot7.left = pRoot6;
        pRoot7.right = pRoot8;
        System.out.println(new GetKthNode().KthNode(pRoot5, 1).val);
    }


    int index = 0; //计数器

    TreeNode KthNode(TreeNode root, int k) {

        TreeNode node = null;
        if (root != null && k > 0) {
            node = KthNode(root.left, k);
            if (node != null)
                return node;
            if (++index == k)
                return root;
            node = KthNode(root.right, k);
            if (node != null)
                return node;

        }
        return null;
    }

    public static class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

}
