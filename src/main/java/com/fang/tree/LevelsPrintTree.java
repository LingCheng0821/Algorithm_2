package com.fang.tree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class LevelsPrintTree {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        ArrayList<ArrayList<Integer>> result =LevelsPrintTree.Print(node1);
        for (ArrayList<Integer> list : result) {
            list.forEach((s) -> System.out.print(s + "-->"));
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>>  Print(TreeNode pRoot) {
        ArrayList<Integer> tmp = new ArrayList<>();

        if(pRoot == null)
            return null;
        LinkedList<TreeNode> queue  = new LinkedList<>(); //队列LinkedList完成层序遍历
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();


        TreeNode current = null; //当前节点

        int now = 1, next = 0;//now 用于记录遍历的个数，next表示每层节点数量

        queue.add(pRoot);//将根节点入队

        while(!queue.isEmpty()) {
            current = queue.poll();//出队队头元素并访问
            now--;

            tmp.add(current.val); //添加到list

            if(current.left != null) { //如果当前节点的左节点不为空入队
                queue.add(current.left);
                next++;
            }
            if(current.right != null) { //如果当前节点的右节点不为空，把右节点入队
                queue.add(current.right);
                next++;
            }
            if(now == 0) {
                ret.add(new ArrayList<Integer>(tmp));
                tmp.clear();
                now = next;
                next = 0;
            }
        }
        return ret;
    }


    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
}
