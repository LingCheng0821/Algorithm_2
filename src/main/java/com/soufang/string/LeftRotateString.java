package com.soufang.string;

import java.util.Arrays;
import java.util.List;

/**
 * 58 反转字符串
 */
public class LeftRotateString {
    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() == 0 || n <= 0) return str;
        int len = str.length();
        int kn = n % len;
        StringBuffer sb = new StringBuffer(str.substring(0, kn));
        StringBuffer sb1 = new StringBuffer(str.substring(kn, len));
        sb1.append(sb);
        return sb1.toString();
    }

    void Reverse(char[] list, int start, int end) {
        char temp;
        while (start < end) {
            temp = list[start];
            list[start] = list[end];
            list[end] = temp;
            start++;
            end--;
        }
    }

    String LeftRotateString1(String str, int n) {
        if (str == null || str.length() == 0 || n <= 0) return str;
        int len = str.length();
        int kn = n % len;
        char[] result = str.toCharArray();
        Reverse(result, 0, kn - 1);
        Reverse(result, kn, len - 1);
        Reverse(result, 0, len - 1);
        return String.valueOf(result);
    }

    /**
     * 输入一个英文句子，反转句子中单词的顺序，但单词内字符的顺序不变。
     * 例如，“student. a am I”,正确的句子应该是“I am a student.”。
     *
     * @param str
     * @return
     */
    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0) return str;
        int len = str.length();
        char[] result = str.toCharArray();
        Reverse(result, 0, len - 1); //反转整个句子
        int start = 0, end = 0;
        while (start != len) {//若起始字符为空格，则begin和end都自加
            if (result[start] == ' ') {
                start++;
                end++;
            } else if (result[end] == ' ') {  //遍历到终止字符为空格，就进行翻转
                Reverse(result, start, --end);
                start = ++end;
            } else if (end == result.length - 1) {//若遍历结束，就进行翻转
                Reverse(result, start, end);
                start = ++end;
            } else {//没有遍历到空格或者遍历结束，则单独对end自减
                end++;
            }
        }
        return String.valueOf(result);
    }


    public static void main(String[] args) {
        String str = "abcdefg";
        int n = 2;
        System.out.println(new LeftRotateString().LeftRotateString1(str, n));
    }


}
