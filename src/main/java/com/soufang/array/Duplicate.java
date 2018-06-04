package com.soufang.array;

/**
 * Created by Laura on 2018/3/26.
 */
public class Duplicate {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        boolean res = false;
        int flag = 0;

        if(numbers == null || numbers.length <= 0) {
            return false;
        }
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if (((flag >> number) & 1) == 1) {
                duplication[0] = number;
                return true;
            }
            flag |= (1 << number);  //用二进制位来判断是否有数字重复
        }
        return false;

    }

}