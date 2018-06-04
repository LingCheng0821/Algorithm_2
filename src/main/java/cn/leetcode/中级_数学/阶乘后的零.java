package cn.leetcode.中级_数学;

import org.junit.Test;

/**
 * Created by Laura on 2018/5/31.
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/53/math/113/
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * 示例 1:
 *      输入: 3
 *      输出: 0
 *      解释: 3! = 6, 尾数中没有零。
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 */
public class 阶乘后的零 {
    @Test
    public void test(){
        int n = 5;
        System.out.println(trailingZeroes(n));
    }
    public int trailingZeroes(int n) {
        if(n <= 0) return 0;
        int res = 0;
        while(n != 0){
            n = n/5;
            res += n ;
        }
        return res;
    }
}
