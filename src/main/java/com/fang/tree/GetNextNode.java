package com.fang.tree;

/**
 * 面试题8：二叉树的下一个结点
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * 解题思路：
 *  中序遍历：左 根 右
 *  （1）有右子树，那么下个节点就是右字数最左边的点；
 *  （2）没有右子树的，也可以分成两类：
 *      a)是父节点左孩子，那么父节点就是下一个节点 ；
 *      b)是父节点的右孩子，找他的父节点的父节点的父节点... 直到当前结点是其父节点的左孩子位置。如果没有，那么他就是尾节点。
 *
 */
public class GetNextNode {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return null;
        TreeLinkNode pNext = null;

        if (pNode.right != null) { //如果有右子树，则找右子树的最左节点

            pNext = pNode.right;
            while (pNext.left != null) {
                pNext = pNext.left;
            }
            return pNext;
        }
        while (pNode.next != null) {  //没右子树，则找第一个当前节点是父节点左孩子的节点
            if (pNode.next.left == pNode) //当前结点是其父节点的左孩子位置，返回父节点
                return pNode.next;
            pNode = pNode.next; //找他的父节点的父节点的父节点
        }

        return null;  //退到了根节点仍没找到，则返回null


    }

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}
