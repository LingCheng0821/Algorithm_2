package com.fang.string;

/**
 * 面试题50（二）：字符流中第一个只出现一次的字符
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 *
 * 解题思路：
 *  利用一个int型数组表示256个字符，这个数组初值置为-1.
 *  没读出一个字符，将该字符的位置存入字符对应数组下标中。
 *  若值为-1标识第一次读入，不为-1且》0表示不是第一次读入，将值改为-2.
 *  之后在数组中找到>0的最小值，该数组下标对应的字符为所求。
 */
public class FirstAppearingOnce {

    private int[] occurence = new int[256];
    private int index;


    public FirstAppearingOnce() {
        for (int i = 0; i < 256; i++) {
            occurence[i] = -1;
        }
        index = 0;
    }


    public void Insert(char ch) {
        if (occurence[ch] == -1) //当ASCII为ch的字符第一次从字符流中读出时，occurrence[ch]更新为它在字符流中的位置
            occurence[ch] = index;
        else if (occurence[ch] >= 0) ////当该字符再次从字符流中读出时，更新为-2
            occurence[ch] = -2;

        index++;
    }

    //return the first appearence once char in current stringstream
    public char firstAppearingOnce() {
        char ch = '\0';
        int minIndex = Integer.MAX_VALUE;
        //遍历数组，找出最小的大于等于0的值对应的字符，就是所求的目前从字符流中读出所有字符中第一个不重复的字符
        for (int i = 0; i < 256; i++) {
            if (occurence[i] >= 0 && occurence[i] < minIndex) {
                ch = (char) i;
                minIndex = occurence[i];
            }
        }
        if (ch == '\0')
            return '#';
        return ch;
    }
}
