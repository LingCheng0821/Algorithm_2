package com.fang.algorithm.find;

/**
 * 杨氏矩阵查找
 * 思想：
 *      先定位第一行最后一个元素，
 *      遇到的数比要找的数大时，向左移动，遇到的数比要找的数小时，向下移动
 *
 */
public class YoungSearch {
    public boolean search(int[][] array, int target){
        int i = 0, j = array[0].length -1;
        int temp = array[i][j];

        while(true){
            if(temp == target) {
                System.out.println("x=" + i + ", y=" + j);
                return true;
            } else if(temp < target && i < array.length - 1){
                temp = array[++i][j];
            }else if(temp > target && j > 0){
                temp = array[i][--j];
            } else {
                System.out.println("Not found");
                return false;
            }

        }
    }
}
