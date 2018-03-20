package com.fang.tree;

import java.util.*;

/**
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class ZhizixingPrint {
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
        ArrayList<ArrayList<Integer>> result = new ZhizixingPrint().Print(node1);
        for (ArrayList<Integer> list : result) {
            list.forEach((s) -> System.out.print(s + "-->"));
            System.out.println();
        }
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<Integer> tmp = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

        if (pRoot == null)
            return ret;


        Stack<TreeNode>[] level = new Stack[] {new Stack<>(), new Stack<>()}; //队列LinkedList完成层序遍历


        TreeNode node = null; //当前节点
        int current = 0, next = 1;//now 用于记录遍历的个数，next表示每层节点数量

        level[current].add(pRoot);//将根节点入队

        while (!level[0].isEmpty() || !level[1].isEmpty()) {

            node = level[current].pop();//出队队头元素并访问

            tmp.add(node.val); //添加到list

            if(current == 0){
                if (node.left != null) { //如果当前节点的左节点不为空入队
                    level[next].push(node.left);
                }
                if (node.right != null) { //如果当前节点的右节点不为空，把右节点入队
                    level[next].push(node.right);
                }
            } else {
                if (node.right != null) { //如果当前节点的右节点不为空，把右节点入队
                    level[next].push(node.right);
                }
                if (node.left != null) { //如果当前节点的左节点不为空入队
                    level[next].push(node.left);
                }
            }


            if (level[current].isEmpty() ) {
                ret.add(new ArrayList<Integer>(tmp));
                tmp.clear();
                current = 1 - current;
                next = 1 - next;
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
