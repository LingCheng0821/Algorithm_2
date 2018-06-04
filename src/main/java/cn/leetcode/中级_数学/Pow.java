package cn.leetcode.中级_数学;

import org.junit.Test;

/**
 * Created by Laura on 2018/5/31.
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/53/math/115/
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * 示例 2:
 * <p>
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * <p>
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 */
public class Pow {
    @Test
    public void test() {
        System.out.println(myPow(2.00000, -2147483648));
//        System.out.println(Math.pow(1.00001, 7483648));
    }

    public double myPow(double x, int n) {
        if(Double.compare(x, 0) == 0 && n < 0) {
            return 0;
        } else if(Double.compare(x, 1) == 0 ) {
            return x;
        } else if(Double.compare(x, -1) == 0){
            if((n & 1) == 0) return 0-x;
            else  return x;
        }

        x = n >= 0 ? x : 1 / x;

        long nl = (n >= 0) ? n : (0L - n);
        return PowerWithUnsignedExponent(x, nl);
    }

    private double PowerWithUnsignedExponent(double base, long exponent) {
        double result = 1.0;

        while(exponent != 0){
            if((exponent & 1)==1 )
                result *= base;
            base *= base ;
//            exponent /= 2;
            exponent >>= 1;
        }
        return result;
    }



}
