package com.soufang.tree;

/**
 * Created by Laura on 2018/3/20.
 */
public class IsBalanced {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private boolean isBalanced=true;
    public boolean IsBalanced_Solution(TreeNode root) {
        IsBalanced(root);
        return isBalanced;
    }

    public int IsBalanced(TreeNode root){
        if(root == null)  return 0;
        int left = IsBalanced(root.left);
        int right = IsBalanced(root.right);

        if(Math.abs(left-right)>1){
            isBalanced=false;
        }
        return right>left ?right+1:left+1;
    }
}
