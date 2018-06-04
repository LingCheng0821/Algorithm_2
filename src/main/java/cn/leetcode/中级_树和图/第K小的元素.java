package cn.leetcode.中级_树和图;

import cn.leetcode.StringUtil;
import org.junit.Test;

import java.util.List;

/**
 * Created by Laura on 2018/5/28.
 * 给定一个二叉搜索树，编写一个函数kthSmallest来查找其中第 k 个最小的元素。
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 * 输入: root = [3,1,4,null,2], k = 1
 * 输出: 1
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 输出: 3
 */
public class 第K小的元素 {
    int index = 0; //计数器
    @Test
    public void test(){
        TreeNode node = TreeNodeUtil.createTree();
        int k = 5;
        int result  = kthSmallest(node, k);
        System.out.println(result);
    }

    public int kthSmallest(TreeNode root, int k) {

        return KthNode(root, k);
    }

    Integer KthNode(TreeNode root, int k) {
        Integer result = null;
        if (root != null && k > 0) {
            result = KthNode(root.left, k);
            if (result != null)  return result;
            if (++index == k)  return root.val;
            result = KthNode(root.right, k);
            if (result != null)   return result;
        }
        return null;
    }

    int count = 0;
    int res = 0;
    public void kthSmallest1(TreeNode root,int k){
        if(root != null){
            if (root.left != null){
                kthSmallest1(root.left,k);
            }
            count++;
            if (count > k)  return;
            if (count == k){
                res = root.val;
                return;
            }
            if (root.right != null){
                kthSmallest1(root.right,k);
            }
        }

    }


}
