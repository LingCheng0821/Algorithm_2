package com.soufang.other;

/**
 * Created by Laura on 2018/3/22.
 */
public class Sum_Solution {
    public int Sum_Solution(int n) {
        int ans = n;
        boolean flag = ((ans != 0) && ((ans += Sum_Solution(n - 1)) != 0));
        return ans;
    }

    public static void main(String[] args) {
        int re = new Sum_Solution().Sum_Solution(4);
        System.out.println(re);
    }
}
