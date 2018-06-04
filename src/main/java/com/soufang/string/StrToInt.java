package com.soufang.string;

/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 *
 */
public class StrToInt {
    public int StrToInt(String str) {
       return parseInt(str, 10);
    }

    public static void main(String[] args) {
        String str = ""+Integer.MAX_VALUE;
        new StrToInt().StrToInt(str);
//        System.out.println(Integer.valueOf("127")==Integer.valueOf("127"));
//        System.out.println(Integer.valueOf("128")==Integer.valueOf("128"));
//        System.out.println(Integer.parseInt("128")==Integer.valueOf("128"));

    }


    public int parseInt(String s, int radix) throws NumberFormatException {
        if (s == null) throw new NumberFormatException("null");


        if (radix < Character.MIN_RADIX) {   //2
            throw new NumberFormatException("radix " + radix + " less than Character.MIN_RADIX");
        }

        if (radix > Character.MAX_RADIX) {  //36
            throw new NumberFormatException("radix " + radix +  " greater than Character.MAX_RADIX");
        }

        int result = 0;
        boolean negative = false;
        int i = 0, len = s.length();
        int limit = -Integer.MAX_VALUE;
        int multmin;
        int digit;

        if (len > 0) {
            char firstChar = s.charAt(0);
            if (firstChar < '0') { // Possible leading "+" or "-"
                if (firstChar == '-') {
                    negative = true;
                    limit = Integer.MIN_VALUE;
                } else if (firstChar != '+')
                    throw new NumberFormatException("For input string: \"" + s + "\"");

                if (len == 1) // Cannot have lone "+" or "-"
                    throw new NumberFormatException("For input string: \"" + s + "\"");
                i++;
            }
            multmin = limit / radix;
            while (i < len) {
                // Accumulating negatively avoids surprises near MAX_VALUE
                digit = Character.digit(s.charAt(i++),radix);
                if (digit < 0) {
                    throw new NumberFormatException("For input string: \"" + s + "\"");
                }
                if (result < multmin) {
                    throw new NumberFormatException("For input string: \"" + s + "\"");
                }
                result *= radix;
                if (result < limit + digit) {
                    throw new NumberFormatException("For input string: \"" + s + "\"");
                }
                result -= digit;
            }
        } else {
            throw new NumberFormatException("For input string: \"" + s + "\"");
        }
        return negative ? result : -result;
    }
}
