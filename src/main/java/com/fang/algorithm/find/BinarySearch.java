package com.fang.algorithm.find;

/**
 * Created by Laura on 2018/3/7.
 */
public class BinarySearch {

    public boolean search(int[] array, int target){
        int start = 0;
        int end = array.length - 1;
        int mid = -1;

        while(start <= end){
            mid = (start + end) / 2;
            if(array[mid] > target)
                end = mid -1;
            else if(array[mid] < target)
                start = mid + 1;
            else {
                System.out.println("found!");
                return true;
            }
        }
        return  false;
    }

}

