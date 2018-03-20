package com.fang.linkedlist;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DelDuplication {

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null)
            return null;
        ListNode first = new ListNode(-1);//设置一个trick
        first.next = pHead;

        ListNode pNode = pHead;
        ListNode last = first;

        while (pNode != null && pNode.next != null) {

            if (pNode.val == pNode.next.val) {
                int val = pNode.val;
                while (pNode != null && pNode.val == val)
                    pNode = pNode.next;
                last.next = pNode;
            } else {
                last = pNode;
                pNode = pNode.next;
            }
        }
        return first.next;


    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
