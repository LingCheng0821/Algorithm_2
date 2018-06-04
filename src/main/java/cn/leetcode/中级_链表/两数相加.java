package cn.leetcode.中级_链表;

import cn.leetcode.StringUtil;

/**
 * Created by Laura on 2018/5/26.
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class 两数相加 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(1);
//        ListNode node1= new ListNode();
        node1.next = node2;

        ListNode result = addTwoNumbers(node1, node3);
        StringUtil.print(result);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //==========预处理,保证计算不出nullpointer错
        if (l1 == null) l1 = new ListNode(0);
        if (l2 == null) l2 = new ListNode(0);
        //其中有一个数为 0
        if (l1.next == null && l1.val == 0) return l2;
        if (l2.next == null && l2.val == 0) return l1;

        int sum = l1.val + l2.val;    //保存结果
        int carry = sum / 10;         //保存进位
        ListNode result = new ListNode(sum % 10);  //结果
        l1 = l1.next; l2 = l2.next;

        ListNode cache = result;
        while (l1 != null || l2 != null || carry > 0) {
            sum = carry;
            if (l1 != null) sum += l1.val;
            if (l2 != null)  sum += l2.val;

            cache.next = new ListNode(sum % 10);
            carry = sum / 10;
            cache = cache.next;

            if (l1 != null)  l1 = l1.next;
            if (l2 != null)  l2 = l2.next;

        }
        return result;
    }


}


