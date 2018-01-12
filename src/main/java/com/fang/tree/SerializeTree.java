package com.fang.tree;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树.
 * 解题思路：
 *  可以从前序遍历序列和中序遍历序列中构造出一颗二叉树，
 *  缺点：①该方法要求二叉树中不能有数值重复的节点；②只有当两个序列中所有数据都读出后才能开始反序列化。
 *  实际上，如果二叉树的序列化是从根节点开始的，那么相应的反序列化在根节点的数值读出来的时候就可以开始了。
 *  因此，我们可以根据前序遍历的顺序来序列化二叉树。
 *
 */
public class SerializeTree {
    public static void main(String[] args) {
        String[] strs = {"1","2","4","$","$","$","3","5","$","$","6","$","$"};
        new SerializeTree().Deserialize2(strs);
    }
    private final String NULLSTR = "$";
    private final String SPILE = ",";
    int index = -1;
    String Serialize(TreeNode root) {
        if(root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        Serialize2(root, sb);
        return sb.toString();
    }

    private void Serialize2(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append(NULLSTR).append(SPILE);
            return;
        }
        sb.append(root.val);
        sb.append(',');
        Serialize2(root.left, sb);
        Serialize2(root.right, sb);
    }

    TreeNode Deserialize(String str) {
        if(str == null || str.length() == 0)
            return null;
        String[] strs = str.split(SPILE);
        return Deserialize2(strs);
    }

    private TreeNode Deserialize2(String[] strs) {
        index++;
        if(!strs[index].equals(NULLSTR)) {
            TreeNode root = new TreeNode(0);
            root.val = Integer.parseInt(strs[index]);
            root.left = Deserialize2(strs);
            root.right = Deserialize2(strs);
            return root;
        }
        return null;
    }


    public static class TreeNode {
        int val ;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}

