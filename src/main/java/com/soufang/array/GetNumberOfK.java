package com.soufang.array;

/**
 * 53 在排序数组中查找数字
 *
 */
public class GetNumberOfK {
    public int GetNumberOfK(int [] array , int k) {
        int number = 0;
        if(array != null && array.length > 0){
            int length = array.length;
            int firstK = getFirstK(array, k, 0, length-1);
            int lastK = getLastK(array, k, 0, length-1);
            if(firstK != -1 && lastK != -1){
                number =  lastK - firstK + 1;
            }
        }
        return number;
    }


    /**
     * 递归写
     */
    private int getFirstK(int [] array , int k, int start, int end){
        if(start > end)  return -1;
        int mid = (start + end) >> 1;
        if(array[mid] > k){ //如果中间的数字比K大，那么k只能出现在前半段
            return getFirstK(array, k, start, mid-1);
        }else if (array[mid] < k){  //如果中间的数字比K小，那么K只能出现在后半段
            return getFirstK(array, k, mid+1, end);
        }//如果中间的数字=K，那么比较mid-1的数字：如果相等，则在前半段
        else if(mid-1 >=0 && array[mid-1] == k){
            return getFirstK(array, k, start, mid-1);
        }else{  //如果小于，mid就为第一个位置
            return mid;
        }
    }

    //循环写法
    private int getLastK(int [] array , int k, int start, int end){
        if(start > end)  return -1;
        int length = array.length;
        int mid = (start + end) >> 1;
        while(start <= end){
            if(array[mid] > k){  //中间的数字比K大，只能在前半段
                end = mid-1;
            }else if(array[mid] < k){ //中间的数字比K小，只能在后半段
                start = mid+1;
            } //中间的数字=K，比较mid后面的数字，如果相等，只能在后半段
            else if(mid+1 < length && array[mid+1] == k){
                start = mid+1;
            }else{   //如果不相等，mid就为最后一个位置
                return mid;
            }
            mid = (start + end) >> 1;
        }
        return -1;
    }

}
