package com.soufang.array;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class HasSomeNum {
    public boolean Find(int target, int[][] array) {
        boolean flag = false;
        int rowSize = array.length;   //行数
        int colSize = array[0].length; //列数

        for (int i = rowSize - 1, j = 0; i >= 0 && j < colSize; ) {
            if (target == array[i][j]) {
                flag = true;
                break;
            } else if (target < array[i][j]) {
                i--;
            } else {
                j++;
            }
        }
        return flag;
    }

    public boolean search(int[][] array, int target){
        boolean flag = false;

        for(int i = 0, j = array[0].length - 1; i < array.length  && j >= 0; ){
            if(target == array[i][j]) {
                flag = true;
                break;
            } else if(target > array[i][j]){
                ++i;
            }else if(target < array[i][j]){
                --j;
            }
        }
        return flag;
    }



}



