package com.soufang.link;

/**
 * Created by Laura on 2018/3/13.
 */
public class CloneLink {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead==null)
            return null;
        RandomListNode pCur = pHead;
        //复制next 如原来是A->B->C 变成A->A'->B->B'->C->C'
        while(pCur!=null){
            RandomListNode node = new RandomListNode(pCur.label);
            node.next = pCur.next;
            pCur.next = node;
            pCur = node.next;
        }
        pCur = pHead;
        //复制random pCur是原来链表的结点 pCur.next是复制pCur的结点
        while(pCur!=null){
            if(pCur.random!=null)
                pCur.next.random = pCur.random.next; //pCur.random.next就是pCur.random的复制
            pCur = pCur.next.next;
        }
//        RandomListNode head = pHead.next;
//        RandomListNode cur = head;
//        pCur = pHead;
//        //拆分链表
//        while(pCur!=null){
//            pCur.next = pCur.next.next;
//            if(cur.next!=null)
//                cur.next = cur.next.next;
//            cur = cur.next;
//            pCur = pCur.next;
//        }
//        return head;
        RandomListNode pCloneHead = pHead.next;
        RandomListNode tmp;
        pCur = pHead;
        while(pCur.next !=null){
            tmp = pCur.next;
            pCur.next =tmp.next;
            pCur = tmp;
        }
        return pCloneHead;

    }

    public static void main(String[] args) {

    }
}
