package cn.leetcode.中级_树和图;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Laura on 2018/5/28.
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/32/trees-and-graphs/88/
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 *  说明:
 *      你只能使用额外常数空间。
 *      使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 *      你可以假设它是一个完美二叉树（即所有叶子节点都在同一层，每个父节点都有两个子节点）。
 *  示例:
 *      给定完美二叉树：
 *            1
 *          /  \
 *         2    3
 *        / \  / \
 *       4  5  6  7
 *
 * 调用你的函数后，该完美二叉树变为：
 *            1 -> NULL
 *          /  \
 *         2 -> 3 -> NULL
 *        / \  / \
 *       4->5->6->7 -> NULL
 *
 */
public class 每个节点的右向指针 {
    public void connect(TreeLinkNode root) {
        if(root == null ) return;

        Queue<TreeLinkNode> cache = new LinkedList<>();
        cache.add(root);

        while(!cache.isEmpty()){
            int count = cache.size();
            TreeLinkNode first = null;
            TreeLinkNode next = null;
            while(count > 0){
                next = cache.remove();
                if(next.left != null) cache.add(next.left);
                if(next.right != null) cache.add(next.right);
                if(first != null) first.next = next;
                first = next;
                count--;
            }
            next.next = null;
        }
    }
    public void connect1(TreeLinkNode root) {
        if (root == null) return;
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null)
                root.right.next = root.next.left;
        }

        connect1(root.left);
        connect1(root.right);
    }
}
