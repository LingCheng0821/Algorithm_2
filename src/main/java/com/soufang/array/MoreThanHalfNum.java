package com.soufang.array;

/**
 * 39 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，输出2。如果不存在则输出0。
 */
public class MoreThanHalfNum {
    //时间复杂度：O(n)
    public int MoreThanHalfNum_Solution(int [] array) {
        int length = array.length;
        if(array == null || length <= 0)  return 0;

        int result = array[0];
        int times = 1;
        for (int i = 1; i < length; i++) {
            if(times == 0){
                result = array[i];
                times = 1;
            }else if(array[i] == result)
                times++;
            else
                times--;
        }
        if(!CheckMoreThanHalf(array, length, result))
            result = 0;
        return result;

    }



    boolean CheckMoreThanHalf(int[] numbers, int length, int number){
        int times = 0;
        for (int i = 0; i < length; i++){
            if(numbers[i] == number)
                times++;
        }
        boolean flag = true;
        if(times * 2 <= length){
            flag = false;
        }
        return flag;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,2,2,2,2,2,2,2};
        int res = new MoreThanHalfNum().MoreThanHalfNum_Solution(array);
        System.out.println(res);
    }
}
