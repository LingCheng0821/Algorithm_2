package com.fang.string;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 *
 * 解题思路：
 *      题目里写了数组里数字的范围保证在0 ~ n-1 之间，所以可以利用现有数组设置标志，当一个数字被访问过后，可以设置对应位上的数 + n，
 *      之后再遇到相同的数时，会发现对应位上的数已经大于等于n了，那么直接返回这个数即可。
 */
public class FirstAppearingNotOnce {
    // Parameters:
    //        numbers:     an array of integers
    //        length:      the length of array numbers
    //        duplication: (Output) the duplicated number in the array number
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        boolean flag = false;
        int index;
        for ( int i= 0 ; i<length; i++) {
            index = numbers[i];

            if (index >= length) {
                index -= length;
            }
            if (numbers[index] >= length) {
                duplication[0] =  index;
                flag = true;
                break;
            }
            numbers[index] = numbers[index] + length;
        }
        return flag;
    }

}
