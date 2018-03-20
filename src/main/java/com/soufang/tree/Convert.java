package com.soufang.tree;

import java.util.Stack;

/**
 * 36 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向.
 * 思路：中序遍历
 */
public class Convert {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode ConvertBSTToBiList(TreeNode root) {
        if(root==null) return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        TreeNode pre = null;// 用于保存中序遍历序列的上一节点
        boolean isFirst = true;
        while(p!=null||!stack.isEmpty()){
            while(p!=null){
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if(isFirst){
                root = p;// 将中序遍历序列中的第一个节点记为root
                pre = root;
                isFirst = false;
            }else{
                pre.right = p;
                p.left = pre;
                pre = p;
            }
            p = p.right;
        }
        return root;
    }

    /**
    解题思路：
            1.将左子树构造成双链表，并返回链表头节点。
            2.定位至左子树双链表最后一个节点。
            3.如果左子树链表不为空的话，将当前root追加到左子树链表。
            4.将右子树构造成双链表，并返回链表头节点。
            5.如果右子树链表不为空的话，将该链表追加到root节点之后。
            6.根据左子树链表是否为空确定返回的节点。
    */
    protected TreeNode leftLast = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null)  return null;
        if(pRootOfTree.left==null && pRootOfTree.right==null){
            leftLast = pRootOfTree;// 最后的一个节点可能为最右侧的叶节点
            return pRootOfTree;
        }
        // 1.将左子树构造成双链表，并返回链表头节点
        TreeNode left = Convert(pRootOfTree.left);
        // 3.如果左子树链表不为空的话，将当前root追加到左子树链表
        if(left!=null){
            leftLast.right = pRootOfTree;
            pRootOfTree.left = leftLast;
        }
        leftLast = pRootOfTree;// 当根节点只含左子树时，则该根节点为最后一个节点
        // 4.将右子树构造成双链表，并返回链表头节点
        TreeNode right = Convert(pRootOfTree.right);
        // 5.如果右子树链表不为空的话，将该链表追加到root节点之后
        if(right!=null){
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }
        return left!=null?left:pRootOfTree;
    }

    protected static TreeNode pLastNodeInList = null;

    public TreeNode Convert1(TreeNode pRootOfTree){
        TreeNode pLastNodeInList = null; //指向双向链表的为节点
        pLastNodeInList = ConvertNode(pRootOfTree);
        TreeNode pHeadOfList = pLastNodeInList;
        // 返回头节点
        while (pHeadOfList != null && pHeadOfList.left != null){
            pHeadOfList = pHeadOfList.left;
        }
        return pHeadOfList;
    }



    private TreeNode ConvertNode(TreeNode pRootOfTree) {
        if(pRootOfTree==null) return null;
        TreeNode pCurrent = pRootOfTree;
        if(pCurrent.left != null)
            pLastNodeInList =  ConvertNode(pCurrent.left);
        pCurrent.left = pLastNodeInList;

        if(pLastNodeInList != null){
            pLastNodeInList.right = pCurrent;
        }
        pLastNodeInList = pCurrent;
        if(pCurrent.right != null)
            pLastNodeInList = ConvertNode(pCurrent.right);
        return pLastNodeInList;
    }

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node8 = new TreeNode(8);
        TreeNode node10 = new TreeNode(10);
        TreeNode node12 = new TreeNode(12);
        TreeNode node14 = new TreeNode(14);
        TreeNode node16 = new TreeNode(16);

        node10.left = node6;
        node6.left = node4;
        node6.right = node8;
        node10.right = node14;
        node14.left = node12;
        node14.right = node16;

        Convert convert = new Convert();
        TreeNode result = convert.Convert1(node10);

        while (result != null){
            System.out.println(result.val + "");
            result = result.right;
        }


    }

}
