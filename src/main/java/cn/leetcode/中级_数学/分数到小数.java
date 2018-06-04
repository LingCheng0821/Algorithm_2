package cn.leetcode.中级_数学;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Laura on 2018/6/1.
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/53/math/118/
 * <p>
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 * <p>
 * 示例 1:
 * 输入: numerator = 1, denominator = 2
 * 输出: "0.5"
 * <p>
 * 示例 2:
 * 输入: numerator = 2, denominator = 3
 * 输出: "0.(6)"
 */
public class 分数到小数 {

    @Test
    public  void test(){
        int numerator = 1;
        int denominator = 6;
        System.out.println(fractionToDecimal(numerator, denominator));
    }


    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0 || numerator == 0) return "0";

        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        Map<Long, Integer> restMap = new HashMap<>();

        StringBuilder decimal  = new StringBuilder();

        //整数部分
        if (num % den == 0){
            decimal.append(num / den);
        } else{
            decimal.append(num / den).append(".");
        }

        //小数部分
        int index = 0; //整数的长度
        long rest = num % den;        //余数

        StringBuilder sb = new StringBuilder();
        while (rest != 0 && restMap.get(rest) == null) {
            restMap.put(rest, index++);
            rest *= 10;
            sb.append(rest / den);
            rest = rest % den;
        }

        if (rest != 0) {
            sb.insert(restMap.get(rest),"(").append(")");
        }
        decimal.append(sb);

        if ((numerator < 0) ^ (denominator < 0))
            decimal = new StringBuilder("-").append(decimal);

        return decimal.toString();

    }

}
