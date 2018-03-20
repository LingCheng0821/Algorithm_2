package com.fang.string;

/**
 * // 面试题20：表示数值的字符串
 * // 题目：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，
 * // 字符串“+100”、“5e2”、“-123”、“3.1416”及“-1E-16”都表示数值，但“12e”、
 * // “1a3.14”、“1.2.3”、“+-5”及“12e+5.4”都不是
 */
public class IsNumeric {
    // 数字的格式可以用A[.[B]][e|EC]或者.B[e|EC]表示，其中A和C都是
    // 整数（可以有正负号，也可以没有），而B是一个无符号整数

    private int inx;

    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        inx = 0;
        boolean flag = scanInteger(str);

        //判断小数部分
        // 如果出现'.'，接下来是数字的小数部分
        if (inx < str.length && str[inx] == '.') {
            inx++;
            // 下面一行代码用||的原因：
            // 1. 小数可以没有整数部分，例如.123等于0.123；
            // 2. 小数点后面可以没有数字，例如233.等于233.0；
            // 3. 当然小数点前面和后面可以有数字，例如233.666
            flag = scanUInteger(str) || flag;     //解释a,见代码下方
        }
        //如果出现'e'或者'E'，接下来跟着的是数字的指数部分
        if (inx < str.length && (str[inx] == 'e' || str[inx] == 'E')) {
            inx++;
            // 下面一行代码用&&的原因：
            // 1. 当e或E前面没有数字时，整个字符串不能表示数字，例如.e1、e1；
            // 2. 当e或E后面没有整数时，整个字符串不能表示数字，例如12e、12e+5.4
            flag = flag && scanInteger(str);
        }
        return flag && inx >= str.length;
    }

    //判断是否是整数
    //整数的格式可以用[+|-]B表示, 其中B为无符号整数
    public boolean scanInteger(char[] str) {
        if (inx < str.length && (str[inx] == '+' || str[inx] == '-')) {
            inx = inx + 1;
        }
        return scanUInteger(str);
    }

    //判断是否是无符号整数
    public boolean scanUInteger(char[] str) {
        int inx1 = inx;
        while (inx < str.length && str[inx] >= '0' && str[inx] <= '9') {
            inx = inx + 1;
        }
        // 当str中存在若干0-9的数字时，返回true
        return inx > inx1;

    }
}
