package com.fang.algorithm.stackQueeueList;


import java.util.Stack;

/**
 * 用两个栈实现队列
 * 思想：
 *      入队都在stack1进行，出队都在stack2进行
 *      入队：直接把元素亚茹stack1中
 *      出队：如果stack2不为空，则直接弹出stack2中的元素；
 *            如果Stack2为空，则将stack1中的所有元素倒入stack2中，然后弹出stack2中的栈顶元素。
 *            若都为空，出队失败
 */
public class Stack2Queue {
    private Stack stack1;
    private Stack stack2;
    private int maxLength;

    public Stack2Queue(int maxLength) {
        this.maxLength = maxLength;
        this.stack1 = new Stack();
        this.stack2 = new Stack();
    }

    public boolean push(int item){
        if(stack1.size() == maxLength){
            return false;
        }
        stack1.push(item);
        return true;
    }

    public Object  poll(){
        if(stack2.isEmpty() && stack1.isEmpty())
            return null;
        if(!stack2.isEmpty()){
            return stack2.pop();
        } else {
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());

            }
            return stack2.pop();
        }
    }
    public int size(){
        return stack1.size() + stack2.size();
    }

}
