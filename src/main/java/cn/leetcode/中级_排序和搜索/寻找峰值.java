package cn.leetcode.中级_排序和搜索;

import org.junit.Test;

/**
 * Created by Laura on 2018/6/4.
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/50/sorting-and-searching/99/
 * 峰值元素是指其值大于左右相邻值的元素。
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞。
 * <p>
 * 说明:
 * 你的解法应该是 O(logN) 时间复杂度的。
 */
public class 寻找峰值 {

    @Test
    public void test() {
        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(findPeakElement(nums));
    }

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length < 1) return -1;
        if (nums.length == 1 )  return 0;
        if(nums[0] > nums[1])  return 0;
        int len = nums.length - 1;
        if (nums[len] > nums[len - 1]) return len;

        return findElement(nums, 1, len - 1);
    }

    //二分查找
    private int findElement(int[] nums, int start, int end) {
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                return mid;
            else if (nums[mid] < nums[mid - 1]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if(nums[start] < nums[end])
            return end;
        else
            return start;
    }
}
