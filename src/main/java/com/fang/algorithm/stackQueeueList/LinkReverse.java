package com.fang.algorithm.stackQueeueList;

/**
 * 反转链表
 */
public class LinkReverse {
    class Node{
        private int data;
        private Node next;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    class Link {
        private int size = 0;
        private Node first ;
        private Node last;

        public  Link(){}

        public void addLast(int data){
            if(size == 0){
                fillStart(data);
            }else{
                Node node = new Node();
                node.setData(data);
                last.setNext(node);
                last = node;
            }
            size ++;
        }

        public void fillStart(int data){
            first = new Node();
            first.setData(data);
            last = first;
        }

        public void reverse(){

            Node temp = first;
            last = temp;
            Node next = first.getNext();
            for (int i = 0; i < size-1; i++) {
                Node nextNext = next.getNext();
                next.setNext(temp);
                temp = next;
                next = nextNext;
            }
            last.setNext(null);
            first = temp;
        }
    }


}
