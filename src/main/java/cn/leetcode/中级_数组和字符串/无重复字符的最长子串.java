package cn.leetcode.中级_数组和字符串;

import java.util.*;

/**
 * Created by Laura on 2018/5/25.
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 * 示例：
 *
 * 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
 * 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
 * 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
 */
public class 无重复字符的最长子串 {

    public static void main(String[] args) {
        String str = "bacdcefg";
        System.out.println(lengthOfLongestSubstring(str));
    }
    public static int lengthOfLongestSubstring(String s) {
        int max=0;  int count=0;
        char[] c=s.toCharArray();

        for(int i=0;i<c.length;i++){
            for(int j=count;j<i;j++){
                if(c[i]==c[j]){
                    count=j+1;
                    break;
                }
            }
            max=Math.max(max,i-count+1);
        }
        return max;

    }

//    public static int lengthOfLongestSubstring(String s) {
//        if(s == null || s.length() < 1) return 0;
//        if(s.length() == 1) return 1;
//
//        int result = 0;
//        int begin = 0, end = 0;
//
//        Map<Character, Integer> map = new HashMap<>();
//        char[] str = s.toCharArray();
//
//        char ch;
//        for (int i = 0; i < str.length; i++) {
//            Integer index ;
//            ch = str[i];
//            if((index=map.get(ch)) != null && index >= begin){  //重复
//                if(result < end - begin) {
//                    result = end - begin;
//                }
//                begin = index + 1;
//                end = begin;
//            }
//            map.put(ch, i);
//            end = i ;
//        }
//        result = result > end - begin ? result : end - begin;
//
//        return result + 1;
//    }

}
