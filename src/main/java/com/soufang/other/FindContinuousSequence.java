package com.soufang.other;

import java.util.ArrayList;

/**
 * 57 和为S的数字
 * 题目：找出所有和为S的连续正数序列?
 * 思路：考虑使用small/big表示序列中最小/大的数.
 * 首先初始化为：small=1，big=2,
 * small到big序列和小于S，big++；大于S，删除small,然后small++
 * 知道small = (1+s)/2结束。
 */
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (sum < 3) return res;
        int small = 1, big = 2;
        int middle = (1 + sum) / 2;
        int curSum = small + big;

        while(small < middle ){
            while(curSum > sum && small < middle){
                curSum -= small;
                small++;
            }
            if(curSum == sum) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                for (int i = small; i <= big ; i++) {
                    list.add(i);
                }
                res.add(list);
            }
            big++;
            curSum += big;
        }
        return res;
    }


    /**
     * 57 和为S的两个数字
     * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，
     * 如果有多对数字的和等于S，输出两个数的乘积最小的。
     */

    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if(array == null || array.length < 1)  return res;
        int start = 0, end = array.length - 1;
        while(end > start){
            int curSum = array[start] + array[end];
            if(curSum == sum){
                res.add(array[start]);
                res.add(array[end]);
                return  res;
            }else if(curSum > sum){
                end--;
            }else
                start++;
        }
        return res;
    }
}
