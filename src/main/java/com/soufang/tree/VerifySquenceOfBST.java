package com.soufang.tree;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。
 * BST的后序序列的合法序列是，对于一个序列S，最后一个元素是x （也就是根），
 * 如果去掉最后一个元素的序列为T，那么T满足：T可以分成两段，前一段（左子树）小于x，后一段（右子树）大于x，且这两段（子树）都是合法的后序序列。完美的递归定义 : ) 。
 */
public class VerifySquenceOfBST {

    public boolean verifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0)
            return false;
        return judge(sequence, 0, sequence.length - 1);
    }

    boolean judge(int[] a, int left, int right){
        if(left >= right)   return true;
        int i = left;
        //(left,i)：小于根节点的；[i,right):大于根节点
        for (; i < right; i++) {   //左边都小于根节点：a[right]
            if (a[i] > a[right])
                break;
        }
        for(int j = i; j < right; j++) {    //右边都大于根节点：a[right]
            if (a[j] < a[right])
                return false;
        }
        return judge(a, left, i - 1) && (judge(a, i, right - 1));
    }
}
