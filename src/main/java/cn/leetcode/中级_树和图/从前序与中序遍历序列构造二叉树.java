package cn.leetcode.中级_树和图;

import cn.leetcode.StringUtil;
import org.junit.Test;

import java.util.List;

/**
 * Created by Laura on 2018/5/28.
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * 3
 * / \
 * 9  20
 * /     \
 * 15     7
 */
public class 从前序与中序遍历序列构造二叉树 {

    @Test
    public void test() {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode node = buildTree1(preorder, inorder);
        遍历二叉树.levelOrder(node);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length
                || preorder.length <= 0 || inorder.length <= 0)
            return null;

        TreeNode root = reConstructBinaryTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return root;

    }

    public TreeNode reConstructBinaryTree(int [] pre,int startPre, int endPre, int [] in, int startIn, int endIn){
        if(startPre > endPre){
            return null;
        }
        //在前序遍历序列中第一个数字是树的根节点的值
        TreeNode root = new TreeNode(pre[startPre]);
        for(int index = startIn; index <= endIn; index++){ //遍历中序序列
            if(in[index] == pre[startPre]){	//找到根节点在中序序列中的位置，递归实现左右子树
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + index - startIn, in, startIn, index-1);
                root.right = reConstructBinaryTree(pre, startPre + index - startIn + 1, endPre, in, index + 1, endIn);
            }
        }
        return root;
    }
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length <= 0) return null;
            return buildTree(preorder, inorder, 0, inorder.length -1, 0);
    }

    /**
     *
     * @param preorder  前序序列
     * @param inorder   中序序列
     * @param istart    中序序列开始索引
     * @param iend      中序序列结束索引
     * @param root      前序序列开始索引
     * @return
     */
    private TreeNode buildTree(int[] preorder, int[] inorder, int istart, int iend, int root) {

        int value = preorder[root]; //在前序遍历序列中第一个数字是树的根节点的值

        TreeNode treeNode = new TreeNode(value);
        for (int i = istart; i < iend; i++) { //遍历中序序列,找到根节点在中序序列中的位置
            if (value == inorder[i]) {
                if (i != istart) {
                    treeNode.left = buildTree(preorder, inorder, istart, i - 1, root + 1);
                }
                if (i != iend) {
                    int offset = root -  istart;
                    treeNode.right = buildTree(preorder, inorder, i + 1, iend, i + 1 + offset);
                }
            }
        }

        return treeNode;
    }

}
