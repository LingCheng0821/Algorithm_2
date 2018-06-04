package cn.leetcode.中级_数学;

import org.junit.Test;

/**
 * Created by Laura on 2018/5/31.
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/53/math/114/
 *  给定一个Excel表格中的列名称，返回其相应的列序号。
 *   A -> 1
 *   B -> 2
 *   ...
 *   Z -> 26
 *   AA -> 27
 *   AB -> 28
 */
public class Excel表列序号 {
    @Test
    public void test(){
        System.out.println(titleToNumber("ZY"));
    }

    public int titleToNumber(String s) {
        int len = s.length();
        int res = 0;
        for (int i = 0; i < len; i++) {
            res += (s.charAt(i)-'A' + 1) * Math.pow(26, len-i-1);
        }
        return res;
    }

}
