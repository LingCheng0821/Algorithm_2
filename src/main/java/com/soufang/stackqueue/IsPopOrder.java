package com.soufang.stackqueue;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。（注意：这两个序列的长度是相等的）
 * 思路：
 *      借用一个辅助的栈，遍历压栈顺序，先讲第一个放入栈中，然后判断栈顶元素是不是出栈顺序的第一个元素
 *      如果不相等，则继续压栈，直到相等以后开始出栈，出栈一个元素，则将出栈顺序向后移动一位，直到不相等，
 *      这样循环等压栈顺序遍历完成，如果辅助栈还不为空，说明弹出序列不是该栈的弹出顺序。
 */
public class IsPopOrder {

    public boolean isPopOrder(int [] pushA,int [] popA) {
        if(pushA.length == 0 || popA.length == 0 || pushA.length != popA.length)
            return false;

        Stack<Integer> stack = new Stack<>();


        for(int i = 0,j = 0 ;i < pushA.length;i++){
            stack.push(pushA[i]);
            while(j < popA.length && stack.peek() == popA[j]){
                stack.pop();    //出栈
                j++;   //弹出序列向后一位
            }
        }
        return stack.empty();

    }
}
