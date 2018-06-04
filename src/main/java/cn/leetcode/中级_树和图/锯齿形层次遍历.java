package cn.leetcode.中级_树和图;

import cn.leetcode.StringUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Laura on 2018/5/28.
 * 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：给定二叉树 [3,9,20,null,null,15,7],
 * 返回锯齿形层次遍历如下：[[3],[20,9],[15,7]]
 */
public class 锯齿形层次遍历 {

    @Test
    public void test(){
        TreeNode node = TreeNodeUtil.createTree();
        List<List<Integer>> result = zigzagLevelOrder1(node);
        new StringUtil<Integer>().print(result);
    }

    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        boolean flag = true; //false表示从左到右，true表示从右到左
        TreeNode temp;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();  //记录当前层待处理结点
        LinkedList<TreeNode> nextqueue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int count = queue.size();
            ArrayList<Integer> cache = new ArrayList<>();

            while(count-- > 0){
                temp = queue.removeLast();
                cache.add(temp.val);
                if(flag){
                    if (temp.left != null) {
                        nextqueue.add(temp.left);
                    }
                    if (temp.right != null) {
                        nextqueue.add(temp.right);
                    }
                }else{
                    if (temp.right != null) {
                        nextqueue.add(temp.right);
                    }
                    if (temp.left != null) {
                        nextqueue.add(temp.left);
                    }
                }
            }
            result.add(cache);
            flag = !flag;
            queue = nextqueue;
            nextqueue = new LinkedList<TreeNode>();
        }
        return result;
    }

    private void reverse(ArrayList<Integer> cache) {
        Integer temp ;
        for (int i = 0; i < cache.size() / 2; i++) {
            temp = cache.get(i);
            cache.set(i, cache.get(cache.size() - i - 1));
            cache.set(cache.size() - i - 1, temp);
        }
    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

        if (root == null) return result;

        boolean flag = false;

        queue.add(root);

        while (!queue.isEmpty()) {
            int count = queue.size();
            ArrayList<Integer> cache = new ArrayList<>();
            while(count-- > 0){
                TreeNode temp = queue.remove();
                cache.add(temp.val);
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            if(flag) reverse(cache);
            result.add(cache);
            flag = !flag;
        }
        return result;
    }
}
