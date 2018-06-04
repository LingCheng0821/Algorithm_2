package cn.leetcode.中级_排序和搜索;

import cn.leetcode.StringUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Laura on 2018/6/4.
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/50/sorting-and-searching/96/
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 *
 * 注意:不能使用代码库中的排序函数来解决这道题。
 *      你能想出一个仅使用常数空间的一趟扫描算法吗？
 *
 * 示例:
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 *
 *

 */
public class 分类颜色 {
    @Test
    public void test(){
        int[] nums = new int[] {2,0,2,1,1,0};
        sortColors(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public void sortColors(int[] nums) {
        if(nums == null || nums.length < 2)  return;
        int start = 0;                //最后一个红色的index
        int end = nums.length - 1;    //第一个蓝色的index
        int cur = 0;

        while(cur <= end){
            if( nums[cur] == 0){
                swap(nums, start, cur);
                start++;
                cur++;
            }else if(nums[cur] == 1){
                cur++;
            }else if(nums[cur] == 2){
                swap(nums, end, cur);
                end--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
