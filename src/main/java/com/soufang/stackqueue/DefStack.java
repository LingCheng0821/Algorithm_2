package com.soufang.stackqueue;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * 思路：用一个栈data保存数据，用另外一个栈min保存依次入栈最小的数
 *       每次入栈的时候，如果入栈的元素比min中的栈顶元素小或等于则入栈，否则不如栈。
 *       每次出栈的时候，如果出栈的元素与min中的栈顶元素等于则都出栈，否则不出栈。

 */
public class DefStack {
    Stack<Integer> data = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();
    Integer temp = null;

    public void push(int node) {
        if(temp == null || node <= temp) {
            temp = node;
            min.push(node);
        }
        data.push(node);
    }

    public void pop() {
        int num = data.pop();
        int num2 = min.peek();
        if(num == num2){
            min.pop();
        }
    }

    public int top() {
        int num = data.peek();
        return num;
    }

    public int min() {
        int num = min.peek();
        return num;
    }
}
