package cn.leetcode.中级_数学;

import org.junit.Test;

/**
 * Created by Laura on 2018/5/31.
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/53/math/116/
 *
 * 实现 int sqrt(int x) 函数。计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 示例 1:
 *      输入: 8
 *      输出: 2
 *      明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 */
public class 平方根 {

    @Test
    public void test(){

        int x = 2147395599;
        System.out.println(mySqrt(x));
    }
    public int mySqrt(int x) {
        if(x <= 0) return 0;
        if(x <= 3) return 1;

        int begin = 2;
        int end = x / 2;
        int mid;
        long sum;
        while(begin < end - 1){
            mid = (begin + end ) / 2;
            sum = (long)mid * (long)mid;
            if(sum == x)
               return mid;
            else if(sum > x)
                end = mid;
            else begin = mid;
        }
        return begin;
    }
}
