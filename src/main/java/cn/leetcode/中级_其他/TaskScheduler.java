package cn.leetcode.中级_其他;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Laura on 2018/5/31.
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/54/others/122/
 * <p>
 * 给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。
 * 任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
 * 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 * 你需要计算完成所有任务所需要的最短时间。
 * <p>
 * 示例 1：
 * 输入: tasks = ["A","A","A","B","B","B"], n = 2
 * 输出: 8
 * 执行顺序: A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
 * <p>
 * 注：
 * 任务的总个数为 [1, 10000]。
 * n 的取值范围为 [0, 100]。
 */
public class TaskScheduler {
    /**
     * 思想：首先，找出出现次数最多的那个任务，然后再来安排那些低频任务。
     * 来看一个例子： AAAABBBEEFFGG 3
     * 任务A出现了4次，频率最高，于是在每个A中间加入三个空位，如下：
     * A---A---A---A
     * AB--AB--AB--A   (加入B)
     * ABE-ABE-AB--A   (加入E)
     * ABEFABE-ABF-A   (加入F，每次尽可能填满或者是均匀填充)
     * ABEFABEGABFGA   (加入G)
     * <p>
     * 分成了(mx - 1)块，再加上最后面的字母，其中mx为最大出现次数。 比如上面的例子：mx=4
     * 模块的长度为n+1
     *
     * @param tasks
     * @param n
     * @return
     */

    public int leastInterval(char[] tasks, int n) {
        int[] arrays = new int[128];
        int max = -1;  //任务最多的次数
        int maxCount = 0;  //数量最多的任务数
        int len = tasks.length;

        for (int i = 0; i < len; i++) {   //统计每个任务的数量
            arrays[tasks[i]]++;
        }

        for (int i = 'A'; i <= 'Z'; i++) {  //找出分块数量 和 最后一块数量
            if (arrays[i] == max) {
                maxCount++;
            }
            if (arrays[i] > max) {
                max = arrays[i];
                maxCount = 1;
            }
        }

        return Math.max(len, (n + 1) * (max - 1) + maxCount);
    }


    @Test
    public void test() {
        char[] tasks = {'A', 'A', 'A', 'A', 'B', 'B', 'B', 'B', 'E', 'F', 'F', 'G', 'G'};
        int n = 3;
        System.out.println(leastInterval(tasks, n));
    }
}
