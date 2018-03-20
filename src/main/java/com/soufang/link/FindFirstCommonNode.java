package com.soufang.link;

/**
 * 52 两个链表的第一个公共节点
 * 思路：由于是单向链表，从第一个公共节点开始，之后他们所有的节点都是重合的。
 *      如果两个链表有公共节点，那么公共节点出现在两个链表的尾部，那么最后一个相同的节点就是我们要找的节点。
 *  首先遍历两个链表得到他们的长度，就能知道哪个链表比较长，。在第二次遍历的时候，在较长的链表上先走若干步，接着同时在两个链表上遍历。
 *
 *  时间复杂度为：O(m+n)
 */
public class FindFirstCommonNode {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        int count = 0;
        while(p1!=p2){
            p1 = (p1==null ? pHead2 : p1.next);
            count++;
            p2 = (p2==null ? pHead1 : p2.next);
            count++;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node4.next = node5;
        node5.next = node6;
        ListNode result = new FindFirstCommonNode().FindFirstCommonNode(node1,node4);

        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }


    }
}
