package cn.leetcode.中级_回溯算法;

import org.junit.Test;

import java.util.*;

/**
 * Created by Laura on 2018/5/29.
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/49/backtracking/91/
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 */
public class 电话号码的字母组合 {
    //测试
    @Test
    public void test() {
        List<String> x = letterCombinations("23");
        System.out.println(x.toString());
    }



    static StringBuffer sb = new StringBuffer();
    String[] hm = {"","", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if(digits == null || digits.length() < 1)  return result;

        //开始回溯
        zuhe(digits , 0 , result);

        return result;
    }
    private void zuhe(String digits , int n, List<String> answer) {
        if (n == digits.length()) {
            answer.add(sb.toString());
            return;
        }
        for (int i = 0; i < hm[digits.charAt(n)-'0'].length(); i++) {
            sb.append(hm[digits.charAt(n)-'0'].charAt(i));
            zuhe(digits, n + 1, answer);
            sb.deleteCharAt(sb.length() - 1);
        }
    }



}
