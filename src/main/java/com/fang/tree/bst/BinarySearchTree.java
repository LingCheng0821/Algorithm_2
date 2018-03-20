package com.fang.tree.bst;

/**
 * 二叉搜索树特点：左孩子结点值比当前结点值小，右孩子结点值比当前值大当前值；
 */
public class BinarySearchTree {


    /**
      * 插入
      *      1. 从root节点开始
      *      2. 如果root为空,root为插入值
      *      循环:
      *      3. 如果当前节点值大于插入值,找左节点
      *      4. 如果当前节点值小于插入值,找右节点
      */
    public TreeNode insert(TreeNode root, int value) {      //插入指定值的结点
        TreeNode node = new TreeNode(value);
        TreeNode current = root;
        TreeNode parent  = null;
        if(root == null){
            root = node;
            return root;
        }
        while (true) {
            parent = current;
            if (value < current.getValue()) {
                current = current.getLeftChild();
                if (current == null) {
                    parent.setLeftChild(node);
                    return node;
                }
            } else {
                current = current.getRightChild();
                if (current == null) {
                    parent.setRightChild(node);
                    return node;
                }
            }
        }
    }

    /**
     * 删除节点
     *      1.找到删除节点
     *      2.如果删除节点左节点为空 , 右节点也为空;
     *      3.如果删除节点只有一个子节点 右节点 或者 左节点
     *      4.如果删除节点左右子节点都不为空
     */
    public TreeNode delete (TreeNode root, int key) {
        TreeNode parent  = root;
        TreeNode current = root;
        boolean isLeftChild = false;

        // 找到删除节点
        while (current.getValue() != key) {
            parent = current;
            if (current.getValue() > key) {
                isLeftChild = true;
                current = current.getLeftChild();
            } else {
                isLeftChild = false;
                current = current.getRightChild();
            }

            if (current == null) {
                System.out.println("Not Found!!");
                return current;
            }
        }

        TreeNode leftChild = current.getLeftChild();
        TreeNode rightChild = current.getRightChild();

        // 如果删除节点 没有左、右节点
        if (leftChild == null && rightChild == null) {
            if (current == root) {   //为根节点
                root = null;
            }
            if (isLeftChild == true) {   // 在左子树
                parent.setLeftChild(null);
            } else {
                parent.setRightChild(null);
            }
        } else if (rightChild == null) { //只有左孩子
            if (current == root) {   //删除的根节点，根节点变为左孩子
                root = leftChild;
            } else if (isLeftChild) {   //删除的左节点，父节点的左孩子变为左孩子
                parent.setLeftChild(leftChild);
            } else {   //删除的右节点，父节点的右孩子变为左孩子
                parent.setRightChild(leftChild);
            }

        }  else if (leftChild == null) {  //只有右孩子
            if (current == root) {    //删除的根节点，根节点变为左孩子
                root = rightChild;
            } else if (isLeftChild) {    //删除的左节点，父节点的左孩子变为右孩子
                parent.setLeftChild(rightChild);
            } else {    //删除的右节点，父节点的右孩子变为右孩子
                parent.setRightChild(rightChild);
            }
        }  else if (leftChild != null && rightChild != null) {   // 如果删除节点左右子节点都不为空
            // 找到删除节点的后继者
            TreeNode successor = getDeleteSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.setLeftChild(successor);
            } else {
                parent.setRightChild(successor);
            }
            successor.setLeftChild(current.getLeftChild());
        }
        return current;
    }

    /**
     * 获取删除节点的后继者
     *      删除节点的后继者是在其右节点树种最小的节点
     * @param deleteNode
     * @return
     */
    public TreeNode getDeleteSuccessor(TreeNode deleteNode) {
        // 后继者
        TreeNode successor = null;
        TreeNode successorParent = null;
        TreeNode current = deleteNode.getRightChild();

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }

        // 检查后继者(不可能有左节点树)是否有右节点树
        // 如果它有右节点树,则替换后继者位置,加到后继者父亲节点的左节点.
        if (successor != deleteNode.getRightChild()) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(deleteNode.getRightChild());
        }
        return successor;
    }



    public TreeNode search(TreeNode root, int key) {    //查找指定结点方法
        TreeNode current = root;
        while (current != null && key != current.getValue()) {
            if (key < current.getValue() )
                current = current.getLeftChild();
            else
                current = current.getRightChild();
        }
        return current;
    }


}
