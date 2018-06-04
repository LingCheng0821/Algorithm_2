package cn.leetcode.中级_排序和搜索;

import org.junit.Test;

/**
 * Created by Laura on 2018/6/4.
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/50/sorting-and-searching/100/
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *      输入: nums = [5,7,7,8,8,10], target = 8
 *      输出: [3,4]
 *
 * 示例 2:
 *      输入: nums = [5,7,7,8,8,10], target = 6
 *      输出: [-1,-1]
 */
public class 搜索范围 {
    @Test
    public void test(){
        int[] nums = {1,1,2};
        int target = 1;
        int[] res = searchRange(nums, target);
        for (int var : res){
            System.out.println(var);
        }
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        if(nums.length < 1) return res;

        int start = -1;
        int end = nums.length ;
        while(start + 1 < end){
            int mid = (start + end) / 2;
            if(nums[mid] < target){
                start = mid;
            }else if(nums[mid] > target){
                end = mid;
            } else {
                start = mid;
                end = mid;
                while(start > 0 && nums[start - 1] == target){
                    start = start - 1;
                }
                while(end < nums.length -1 && nums[end + 1] == target){
                    end = end + 1;
                }
                res[0] = start;
                res[1] = end;
                break;
            }
        }

        return res;

    }

}
