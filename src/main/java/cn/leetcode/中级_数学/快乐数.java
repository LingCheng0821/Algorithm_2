package cn.leetcode.中级_数学;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Laura on 2018/5/31.
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/53/math/112/
 * <p>
 * 编写一个算法来判断一个数是不是“快乐数”。
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
 * 然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 * <p>
 * 示例:
 * 输入: 19
 * 输出: true
 * 解释:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */
public class 快乐数 {
    @Test
    public void test() {
        int n = 16;
        System.out.println(isHappy(n));
    }

    static Set<Integer> set = new HashSet<Integer>();
    static{
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(6);
        set.add(8);
        set.add(9);
    }

    public boolean isHappy(int n) {
        if(n <= 0) return false;
        while (n != 1) {
            if (set.contains(n)) {
                return false;
            }
            int sum = 0;
            while (n != 0) {
                sum += Math.pow(n % 10, 2) ;
                n = n / 10;
            }
            n = sum;
        }
        return true;

    }

}
