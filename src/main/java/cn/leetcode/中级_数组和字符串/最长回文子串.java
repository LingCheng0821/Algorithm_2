package cn.leetcode.中级_数组和字符串;

/**
 * Created by Laura on 2018/5/25.
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/29/array-and-strings/79/
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 * 示例 1：
 *      输入: "babad"
 *      输出: "bab"
 * 示例 2：
 *      输入: "cbbd"
 *      输出: "bb"
 */
public class 最长回文子串 {
    public static void main(String[] args) {
        String str = "babad";
        System.out.println(longestPalindrome(str));
    }
    public static String longestPalindrome(String s) {
        if(s == null || s.length() < 2)  return s;

        int max = 1, begin=0, end = 0;
        final String STR = "#";

        //转换字符串
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(STR);
        for (int i = 0; i < s.length(); i++) {
            stringBuilder.append(s.charAt(i));
            stringBuilder.append(STR);
        }

        //处理
        for (int i = 0; i < stringBuilder.length(); i++) {
            for (int j = 1; j <= i; j++) {
                if(i + j == stringBuilder.length()
                        || stringBuilder.charAt(i-j) != stringBuilder.charAt(i+j))  break; //下标越界或者不对称退出

                if(max < 2*j + 1) { //如果当前长度大于max
                    begin = i - j;
                    end = i + j;
                    max = Math.max(max, end - begin + 1);
                }
            }
        }
        return stringBuilder.substring(begin, end).replace(STR, "");
    }

    public static String longestPalindrome1(String s) {

        if(s == null || s.length() < 2)  return s;

        //1、 转换字符串
        StringBuilder stringBuilder = dealWithS(s);

        //2、
        int[] len = new int[stringBuilder.length() ];
        int rightIndex = 0;   // 当前所能扩展的半径
        int centerIndex = 0;  // C位置的半径为R
        //求len中的最大
        int answer = 0;   // 最长的半径的位置
        //answer最大时的中心
        int index = 0;

        for (int i = 1; i < stringBuilder.length(); i++) {
            //当rightIndex > i，那么我们就在rightIndex - i 与len[2 * centerIndex - i](len[j])，取得最小值
            //因为当i + len[j] < rightIndex时，我们就把len[i]更新为len[j]
            //但是如果i + len[j] >= rightIndex时，我们暂且将len[i]定更新为rightIndex - i,超出的部分需要我们一个一个的匹配
            if (rightIndex > i) {
                len[i] = Math.min(rightIndex - i, len[2 * centerIndex - i]);
            } else {
                len[i] = 1;
            }
            //一个一个匹配
            //要么是超出的部分，要么是i > rightIndex
            while(i - len[i] >= 0 && i + len[i] < stringBuilder.length() && stringBuilder.charAt(i - len[i]) == stringBuilder.charAt(i + len[i])) {
                len[i]++;
            }
            //当 len[i] + i > rightIndex,我们需要更新centerIndex和rightIndex
            //至于为什么会这样做，理解一下rightIndex和centerIndex的含义
            if(len[i] + i > rightIndex) {
                rightIndex = len[i] + i;
                centerIndex = i;
            }
            if(len[i] > answer) {
                answer = len[i];
                index = i;
            }
        }
        //截取字符串
        //为什么index - answer + 1,因为len[i] - 1才是原来的回文字符串长度，而answer记录的是len中最大值
        return stringBuilder.substring(index - answer + 1, index + answer).replace("#", "");
    }

    private static StringBuilder dealWithS(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append("#");
        }
        return sb;
    }

}
