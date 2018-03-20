package com.soufang.array;

/**
 * 56 数组中数字出现的次数
 */
public class FindNumsAppearOnce {
    /**
     * 题目：一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
     *      时间复杂度为：O(n)，将num1[0],num2[0]设置为返回结果
     *
     * 思路：位运算中异或的性质：两个相同数字异或=0，一个数和0异或还是它本身。
     * ① 首先从头到尾异或数组中的每个数字，那么最终得到的结果就是两个只出现一次的数字的异或结果。
     * ② 然后在结果数字钟找到第一个为1的位的位置，即为第n位，将第n为是不是1分为两个子数组；
     * ③ 然后然后在异或每个数组，得到结果即为只出现一次的数字
     *
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array==null ||array.length<2)
            return ;
        int resultExclusiveOR = 0;
        for(int i=0;i<array.length;i++)
            resultExclusiveOR ^= array[i];
        int indexOf1 = FindFirstBitIs1(resultExclusiveOR);
        
        for(int i=0;i<array.length;i++){
            if(isBit(array[i], indexOf1))
                num1[0]^=array[i];
            else
                num2[0]^=array[i];
        }
    }

    private int FindFirstBitIs1(int resultExclusiveOR) {
    }

}
