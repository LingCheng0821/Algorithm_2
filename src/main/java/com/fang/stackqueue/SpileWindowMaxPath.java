package com.fang.stackqueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class SpileWindowMaxPath {
    public static void main(String[] args) {
        SpileWindowMaxPath smp = new SpileWindowMaxPath();
        int[] num = {2, 3, 4, 2, 6, 2, 5, 1};
        int size = 3;
        smp.maxInWindowsFor(num, size);
    }

    public ArrayList<Integer> maxInWindows(int[] num, int size) {

        if (null == num || size < 0)
            return null;

        ArrayList<Integer> list = new ArrayList<Integer>();
        if (size == 0)
            return list;

        ArrayList<Integer> temp = null;
        int length = num.length;

        if (length >= size) {
            for (int i = 0; i < length - size + 1; i++) {
                temp = new ArrayList<Integer>();
                for (int j = i; j < size + i; j++) {
                    temp.add(num[j]);
                }
                Collections.sort(temp);
                list.add(temp.get(temp.size() - 1));
            }
        }
        return list;
    }

    //双端队列
    public ArrayList<Integer> maxInWindowsFor(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (size == 0) return res;
        int begin;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < num.length; i++) { //遍历所有元素
            begin = i - size + 1; //找到开始比较的位置
            if (q.isEmpty()) //为空，添加
                q.add(i);
            else if (begin > q.peekFirst()) //first保留最大的数，判断最大的数是否在范围内
                q.pollFirst();   //不在范围内，删除最大的数

            while ((!q.isEmpty()) && num[q.peekLast()] <= num[i]) //q不为空，且新比较的数较大，删除原有的last
                q.pollLast();
            q.add(i); //添加第二大的数
            if (begin >= 0) //有效结果
                res.add(num[q.peekFirst()]);
        }
        return res;
    }
}
