package com.soufang.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Laura on 2018/3/26.
 */
public class GetLowestCommonAncestor {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 如果是二叉搜索树：
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        else
            return root;
    }

    /**
     * 如果树有指向父节点的指针，则转换为：两个链表的公共节点
     */

    /**
     * 如果是普通的数
     */

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null)  return null;

        List<TreeNode> pathp = new ArrayList<>();
        List<TreeNode> pathq = new ArrayList<>();

        getPath(root, p, pathp);
        getPath(root, q, pathq);

        TreeNode lca = null;
        for (int i = 0; i < pathp.size() && i < pathq.size(); i++) {
            if (pathp.get(i) == pathq.get(i))
                lca = pathp.get(i);
            else
                break;
        }
        return lca;
    }

    private boolean getPath(TreeNode pRoot, TreeNode pNode, List<TreeNode> path) {
        if (pRoot == pNode) return true;
        path.add(pRoot);

        boolean found = false;

        if (pRoot.left != null) {
            if (getPath(pRoot.left, pNode, path))
                found = true;
        }

        if (pRoot.right != null) {
            if (getPath(pRoot.right, pNode, path))
                found = true;
        }
        if(!found)
            path.remove(path.size() - 1);
        return found;

    }

    public static void main(String[] args) {
        TreeNode nodeA = new TreeNode(1);
        TreeNode nodeB = new TreeNode(2);
        TreeNode nodeC = new TreeNode(3);
        TreeNode nodeD = new TreeNode(4);
        TreeNode nodeE = new TreeNode(5);
        TreeNode nodeF = new TreeNode(6);
        TreeNode nodeG = new TreeNode(7);
        TreeNode nodeH = new TreeNode(8);
        TreeNode nodeI = new TreeNode(9);
        TreeNode nodeJ = new TreeNode(10);

        nodeA.left = nodeB;
        nodeA.right = nodeC;
        nodeB.left = nodeD;
        nodeB.right = nodeE;
        nodeD.left = nodeF;
        nodeD.right = nodeG;
        nodeE.left = nodeH;
        nodeE.right = nodeI;
        nodeH.right = nodeJ;

        List<TreeNode> pathp = new ArrayList<>();
        List<TreeNode> pathq = new ArrayList<>();

        new GetLowestCommonAncestor().getPath(nodeA, nodeF, pathp);
        new GetLowestCommonAncestor().getPath(nodeA, nodeJ, pathq);

        for (TreeNode node : pathp ) {
            System.out.print(node.val + " ");
        }
        System.out.println();
        for (TreeNode node : pathq ) {
            System.out.print(node.val + " ");
        }


        System.out.println(new GetLowestCommonAncestor().lowestCommonAncestor2(nodeA,nodeF,nodeJ).val);



    }


}
