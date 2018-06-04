package com.soufang.other;

/**
 * 61 扑克牌中的顺子
 * 思路： 必须满足两个条件
 * 1. 除0外没有重复的数
 * 2. max - min < 5
 */
public class IsContinuous {
    public boolean isContinuous(int[] numbers) {
        if (numbers.length != 5) return false;
        int min = 14;
        int max = -1;
        int flag = 0;
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if (number < 0 || number > 13) return false;
            if (number == 0) continue;
            if (((flag >> number) & 1) == 1) return false;
            flag |= (1 << number);  //用二进制位来判断是否有数字重复
            if (number > max) max = number;
            if (number < min) min = number;
            if (max - min >= 5) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 0, 0, 5};
        int flag = 0;
        for (int i = 0; i < num.length; i++) {
            int number = num[i];
            if (((flag >> number) & 1) == 1)
                System.out.println("index="+i+"的"+number + "重复了");
            flag |= (1 << number);  //用二进制位来判断是否有数字重复
        }
    }
}
