package com.fang.string;

/**
 * 面试题67：把字符串转换成整数
 * 题目：请你写一个函数StrToInt，实现把字符串转换成整数这个功能。当然，不能使用atoi或者其他类似的库函数。
 */
public class StringToInt {

    public static void main(String[] args) {

    }
    public int StrToInt(String str) throws NumberFormatException{
        if (str != null) {
            return parseInt(str,10);

        }

        return 0;

    }

    public int parseInt(String s, int radix) throws NumberFormatException {
        int result = 0;

        if (s == null) {
            return result;
//            throw new NumberFormatException("null");
        }

        if (radix < Character.MIN_RADIX) {
            return result;
//            throw new NumberFormatException("radix " + radix + " less than Character.MIN_RADIX");
        }

        if (radix > Character.MAX_RADIX) {
            return result;
//            throw new NumberFormatException("radix " + radix + " greater than Character.MAX_RADIX");
        }

//        int result = 0;
        boolean negative = false;  //是否为负数
        int i = 0, len = s.length();
        int limit = -Integer.MAX_VALUE;  //-0x7FFFFFFF
        int multmin;
        int digit;

        if (len > 0) {
            char firstChar = s.charAt(0);   //第一个字符
            if (firstChar < '0') {          // Possible leading "+" or "-"
                if (firstChar == '-') {
                    negative = true;
                    limit = Integer.MIN_VALUE; //0x80000000
                } else if (firstChar != '+')
                    throw forInputString(s);

                if (len == 1)    // Cannot have lone "+" or "-"
                    throw forInputString(s);
                i++;
            }
            multmin = limit / radix;
            while (i < len) {
                // Accumulating negatively avoids surprises near MAX_VALUE
                digit = Character.digit(s.charAt(i++), radix);
                if (digit < 0) {
                    throw forInputString(s);
                }
                if (result < multmin) {
                    throw forInputString(s);
                }
                result *= radix;
                if (result < limit + digit) {
                    throw forInputString(s);
                }
                result -= digit;
            }
        } else {
            throw forInputString(s);
        }
        return negative ? result : -result;
    }

    static NumberFormatException forInputString(String s) {
        return new NumberFormatException("For input string: \"" + s + "\"");
    }
}
