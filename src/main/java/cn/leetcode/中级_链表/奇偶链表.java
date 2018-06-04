package cn.leetcode.中级_链表;

/**
 * Created by Laura on 2018/5/27.
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes为节点总数。
 *
 * 示例:
 *      输入: 1->2->3->4->5->NULL
 *      输出: 1->3->5->2->4->NULL
 *
 *  说明:
 *      应当保持奇数节点和偶数节点的相对顺序。
 *      链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 */
public class 奇偶链表 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node5;

        ListNode res = oddEvenList(node1);
        print(res);
    }

    public static ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode firstNodeCache = head;
        ListNode secondNodeCache = head.next;   //第一个偶数节点
        ListNode cache = head.next;

        boolean flag = false;

        while(firstNodeCache.next != null && secondNodeCache.next != null){
            if(!flag){
                firstNodeCache.next = secondNodeCache.next;
                firstNodeCache = firstNodeCache.next;
            } else {
                secondNodeCache.next = firstNodeCache.next;
                secondNodeCache = secondNodeCache.next;
            }
            flag = !flag;
        }
        secondNodeCache.next = null;
        firstNodeCache.next = cache;

        return head;
    }

    public static void print(ListNode node){
        System.out.print("{ ");

        while(node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.print("} ");
    }
}
