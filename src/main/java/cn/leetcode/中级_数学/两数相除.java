package cn.leetcode.中级_数学;

import org.junit.Test;

/**
 * Created by Laura on 2018/6/1.
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/53/math/117/
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 说明:
 *      被除数和除数均为 32 位有符号整数。
 *      除数不为 0。
 *      假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 */
public class 两数相除 {
    @Test
    public void test(){
        System.out.println(divide1(1000, -10));
    }

    public int divide(int dividend, int divisor) {
        Long m = Long.valueOf(dividend) ;
        Long n = Long.valueOf(divisor) ;

        return divide(m ,n);
    }

    int divide1(int dividend, int divisor) {
        if(divisor == 0){
            return Integer.MAX_VALUE ;
        }else if(divisor == 1){
            return dividend;
        } else if( divisor==-1 && dividend== Integer.MIN_VALUE){
            return Integer.MAX_VALUE ;
        }

        long m = Math.abs(Long.valueOf(dividend));
        long n = Math.abs(Long.valueOf(divisor));

        if (m < n) return 0;

        long res = 0L;
        while (m >= n) {
            long t = n;
            long p = 1L;
            while (m > (t << 1)) {
                t <<= 1;
                p <<= 1;
            }
            res += p;
            m -= t;
        }
        if ((dividend < 0) ^ (divisor < 0))
            res = -res;

        res = res > Integer.MAX_VALUE ? Integer.MAX_VALUE : res;
        return (int)res;
    }


    public int divide(Long dividend, Long divisor) {
        if(divisor == 0 || (dividend== Integer.MIN_VALUE && divisor==-1)){
            return Integer.MAX_VALUE ;
        }
        boolean neg = false ;
        if(dividend < 0 && divisor > 0){
            neg = true ;
        } else if(dividend > 0 && divisor < 0){
            neg = true ;
        }
        dividend = Math.abs(dividend) ;
        divisor = Math.abs(divisor) ;
        String bigStr = String.valueOf(dividend) ;
        String lessStr = String.valueOf(divisor) ;
        int bigLen = bigStr.length() ;
        int lessLen = lessStr.length() ;
        if(bigLen < lessLen){
            return 0 ;
        }
        String answer = "" ;
        String father = bigStr.substring(0 , lessLen-1) ;
        for(int i = lessLen-1 ;i < bigLen ; i++){
            String curStr = String.format("%s%c" , father , bigStr.charAt(i)) ;
            long cur = Long.valueOf(curStr) ;
            int curBit = 0 ;
            while (cur >= divisor){
                cur -= divisor ;
                curBit++ ;
            }
            answer = String.format("%s%d" , answer , curBit) ;
            if(cur > 0){
                father = String.valueOf(cur) ;
            }
            else {
                father = "" ;
            }
        }
        while (answer.length() > 0 && answer.charAt(0) == '0'){
            answer = answer.substring(1) ;
        }
        long answerLong = "".equals(answer) ? 0 : Long.valueOf(answer) ;
        if(neg){
            answerLong = -answerLong ;
        }
        if(answerLong < Integer.MIN_VALUE || answerLong > Integer.MAX_VALUE){
            return Integer.MAX_VALUE ;
        }
        return (int)answerLong ;
    }
}
