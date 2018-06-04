package cn.leetcode.中级_数组和字符串;

import cn.leetcode.StringUtil;

import java.util.*;

/**
 * Created by Laura on 2018/5/25.
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/29/array-and-strings/77/
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *      ["ate","eat","tea"],
 *      ["nat","tan"],
 *      ["bat"]
 * ]
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class 字谜分组 {
    public static void main(String[] args) {
        String[] strs = {"cab","tin","pew","duh","may","ill","buy","bar","max","doc"};
        List<List<String>> result = groupAnagrams(strs);
        new StringUtil<String>().print(result);
//        String str = "cdba";
//        char[] s = str.toCharArray();
//        Arrays.sort(s);
//        str = String.copyValueOf(s);
//        System.out.println(str);

    }
    public static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new LinkedList<>();
        if(strs == null || strs.length < 1)
            return result;

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs){
            char[] s = str.toCharArray();
            Arrays.sort(s);
            String key = String.copyValueOf(s);


            List<String> list = map.get(key);
            if(list == null){
                list = new LinkedList<>();
                result.add(list);
                map.put(key, list);
            }
            list.add(str);
        }
        return result;
    }

}
