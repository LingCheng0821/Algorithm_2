package cn.leetcode.中级_数组和字符串;

/**
 * Created by Laura on 2018/5/26.
 * 给定一个未排序的数组，请判断这个数组中是否存在长度为3的递增的子序列。
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/29/array-and-strings/80/
 *
 * 正式的数学表达如下:
 *      如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 *      使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。
 *      要求算法时间复杂度为O(n)，空间复杂度为O(1) 。
 */

/**
 * 输入 [1, 2, 3, 4, 5],    输出 true.
 * 输入 [5, 4, 3, 2, 1],    输出 false.
 */
public class 递增的三元子序列 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(increasingTriplet(nums));
    }
    public static boolean increasingTriplet(int[] nums) {
        boolean flag = false;
        if(nums == null || nums.length < 3)
            return flag;

        int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE;
        for (int a : nums) {
            if (m1 >= a) m1 = a;
            else if (m2 >= a) m2 = a;
            else return true;
        }
        return flag;
    }

}
