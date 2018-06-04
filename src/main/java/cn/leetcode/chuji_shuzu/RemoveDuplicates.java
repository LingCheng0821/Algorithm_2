package cn.leetcode.chuji_shuzu;

import java.util.Arrays;

/**
 * Created by Laura on 2018/5/17.
 * 1 从排序数组中删除重复项
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(RemoveDuplicates.removeDuplicates(nums));

        for (int i = 0; i < nums.length; i++) {
            System.out.println(i +"---"+ nums[i]);
        }
    }

    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length <= 0){
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int index = 0;  //用来保存下一个不同的数应该放置的index
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1]){
                nums[index++] = nums[i];
            }
        }
        return index;
    }


}
