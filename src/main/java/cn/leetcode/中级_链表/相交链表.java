package cn.leetcode.中级_链表;

/**
 * Created by Laura on 2018/5/27.
 * 找到两个单链表相交的起始节点。
 * 例如，下面的两个链表：

 A:   a1 → a2
 ↘
 c1 → c2 → c3
 ↗
 B:     b1 → b2 → b3
 在节点 c1 开始相交。
 */
public class 相交链表 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[10000];
        int[] b = new int[10000];
        for (int i = 0; i < 10000; i++) {
            a[i] = 2 * i + 1;
            b[i] = 2 * i;
        }
        ListNode headA = new ListNode(a[0]);
        ListNode headB = new ListNode(b[0]);

        ListNode headAA = headA;
        ListNode headBB = headB;

        for (int i = 1; i < a.length; i++) {
            headA.next = new ListNode(a[i]);
            headA = headA.next;
        }

        for (int i = 1; i < a.length; i++) {
            headB.next = new ListNode(b[i]);
            headB= headB.next;
        }

        long start = System.currentTimeMillis();
        ListNode result = getIntersectionNode(headAA,headBB);
        System.out.println(System.currentTimeMillis()-start);
        print(result);
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        ListNode p1 = headA;
        ListNode p2 = headB;
        while(p1 != p2){
            p1 = (p1 == null) ? headA : p1.next;
            p2 = (p2 == null) ? headB : p2.next;
        }
        return p1;

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
