package cn.leetcode.中级_其他;

import org.junit.Test;

/**
 * Created by Laura on 2018/5/30.
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/54/others/119/
 * 不使用运算符 + 和-，计算两整数a 、b之和。
 * 示例：
 * 若 a = 1 ，b = 2，返回 3。
 */
public class 两整数之和 {
    @Test
    public void test(){
        System.out.println(getSum(1,2));
    }

//    public int getSum(int a,int b) {
//        int sum, carry;
//        while( b != 0){
//            sum = a ^ b;
//            carry = (a & b) << 1; // num1
//            a = sum;
//            b = carry;
//        }
//        return a;
//    }
    public int getSum(int a,int b) {
        int sum,cache;
        while(b != 0) {
            sum = a ^ b;  //异或表示两数相加之和
            cache = (a & b) << 1;  //与 左移以为表示 进位
            a = sum;
            b = cache;
        }
        return a;
    }

}
