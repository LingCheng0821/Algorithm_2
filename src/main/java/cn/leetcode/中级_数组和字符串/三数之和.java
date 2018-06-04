package cn.leetcode.中级_数组和字符串;

import java.util.*;

/**
 * Created by Laura on 2018/5/23.
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/29/array-and-strings/75/
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 */
public class 三数之和 {

    public static void main(String[] args) {
        int[] nums = {-2,0,1,1,2};
        List<List<Integer>> result = threeSum(nums);
        for (int i = 0; i < result.size(); i++) {
            System.out.print("结果： [ ");
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + ", ");
            }
            System.out.println(" ]");
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        if (nums == null || nums.length < 3) return Collections.emptyList();

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Arrays.sort(nums);      //排序


        for (int i = 0; i < nums.length - 2; i++) {
            //最小数 > 0 或者 最大数 < 0 直接退出
            if(nums[i] > 0 || nums[nums.length - 1] < 0) break;

            if(i > 0 && nums[i] == nums[i - 1])
                continue;
            if(nums[i] == nums[nums.length - 1] ){
                if(nums[i] == 0){
                    result.add(Arrays.asList(0, 0, 0));
                    return result;
                } else {
                    return Collections.emptyList();
                }
            }

            int a, b, c;
            a = nums[i];
            int begin = i + 1, end = nums.length - 1;

            while (begin < end) {
                b = nums[begin];
                c = nums[end];
                if (a + b + c > 0) {
                    end--;
                } else if (a + b + c < 0) {
                    begin++;
                } else {
                    result.add(Arrays.asList(a, b, c));
                    while(begin < end && nums[begin] == nums[begin + 1]) ++begin;
                    while(begin < end && nums[end] == nums[end - 1]) --end;
                    ++begin;--end;
                }
            }
        }
        return result;
    }
}
