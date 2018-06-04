package com.soufang.string;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 38 字符串的排列
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba
 */
public class Permutation {
    //基于回溯法
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<String>();
        if (str != null && str.length() > 0) {
            PermutationHelper(str.toCharArray(), 0, res);
            Collections.sort(res);
        }
        return res;
    }

    public void PermutationHelper(char[] cs, int i, ArrayList list) {
        if(i == cs.length - 1) {
            String val = String.valueOf(cs);
            if (!list.contains(val))
                list.add(val);
        } else {
            for(int j = i; j < cs.length; ++j) {
                swap(cs, i, j);
                PermutationHelper(cs, i + 1, list);
                swap(cs, i, j); //交换前后两个字符，在最后交换完成入List之后再交换回来，回到初始状态再进下一个循环
            }
        }
    }

    public static void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }

    public static void main(String[] args) {
        String str = "abc";
        Permutation permutation = new Permutation();
        ArrayList<String> list = permutation.Permutation(str);
        for (String  a :   list ) {
            System.out.println(a);
        }


    }
}
