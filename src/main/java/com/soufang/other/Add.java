package com.soufang.other;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * 13+11 = ？;
 13 的二进制      1 1 0 1                     -----a        13
 11 的二进制      1 0 1 1                     -----b        11  

  (a&b) <<1  ->   1 0 0 1 0                         -----d         18
        a^b  ->     0 1 1 0                   -----e          6

  (d&e) <<1  ->   0 0 1 0 0                       ------f         4
         d^e  ->  1 0 1 0 0                  -----g        20

  (f&g) <<1  ->   0 1 0 0 0                       ------h        8
         f^g  ->  1 0 0 0 0                   ------i           16

  (h&i) <<1  ->   0 0 0 0 0                       ------h        0       ---- --------退出循环
           h^i  ->  1 1 0 0 0                  ------i           24

 链接：https://www.nowcoder.com/questionTerminal/59ac416b4b944300b617d4f7f111b215
 来源：牛客网

 //step1:按位与是查看两个数哪些二进制位都为1，这些都是进位位，结果需左移一位，表示进位后的结果
 //step2:异或是查看两个数哪些二进制位只有一个为1，这些是非进位位，可以直接加、减，结果表示非进位位进行加操作后的结果
 //step3:n1&n2是查看有没有进位位了，如果有，需要重复step1、step2；如果没有，保留n1、n2上二进制为1的部分，用或将之合为一个数，即为最后结果
 */
public class Add {
    public int Add(int num1,int num2) {
        int sum, carry;
        while( num2 != 0){
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1; // num1
            num1 = sum;
            num2 = carry;
        }
        return num1;
    }

    public static void main(String[] args) {
        int num1 =13;
        int num3 = 11;
        System.out.println(new Add().Add(num1,num3));
    }

    public void swap(int a, int b){
        a = a + b;
        b = a - b; //a
        a = a - b;
    }

    public void swap1(int a, int b){
        a = a ^ b;
        b = a ^ b; //a
        a = a ^ b;
    }

}
