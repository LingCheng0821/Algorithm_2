package cn.leetcode.中级_其他;

import org.junit.Test;

/**
 * Created by Laura on 2018/5/31.
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/54/others/121/
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * 示例 2:
 *      输入: [2,2,1,1,1,2,2]
 *      输出: 2
 */
public class 求众数 {

    @Test
    public void test(){
        int[] num = new int[]{2,2,1,1,1,2,3};
        System.out.println(majorityElement(num));
    }
    public int majorityElement(int[] nums) {
        int candidate  = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(count == 0){
                candidate  = nums[i];
            }
            if(candidate  == nums[i]) {
                count++;
            } else
                count--;
        }
        return candidate ;   //一定存在
//        if(MoreThanHalf(nums, result))
//            return result;
//        else
//            return 0;
    }

    private boolean MoreThanHalf(int[] nums, int result) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(result == nums[i])
                count++;
        }
        if(count * 2 <= nums.length)
            return false;
        else return true;
    }
}
