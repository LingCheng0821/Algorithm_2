package cn.leetcode.中级_回溯算法;

import cn.leetcode.StringUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Laura on 2018/5/30.
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/49/backtracking/94/
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * 输入:  nums = [1,2,3]
 * 输出:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class 子集 {
    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> res = subsets1(nums);
        new StringUtil<Integer>().print(res);
//        System.out.println(res);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null) return ret;
        List<Integer> base = new ArrayList<>();
        dfs(0, nums.length, nums, ret, base);
        return ret;
    }

    /**
     * @param cur
     * @param n    长度
     * @param nums
     * @param ret
     * @param base
     */
    private void dfs(int cur, int n, int[] nums, List<List<Integer>> ret, List<Integer> base) {
        if (cur == n) {
            ret.add(new ArrayList<>(base));
            return;
        }
        base.add(nums[cur]);
        dfs(cur + 1, n, nums, ret, base);
        base.remove(base.size() - 1);
        dfs(cur + 1, n, nums, ret, base);
    }

    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null) return ret;
        List<Integer> base = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            backtracking(nums, i, 0,base,ret);
        }
        return ret;
    }

    public void backtracking(int[] nums, int k, int start, List<Integer> list, List<List<Integer>> ret) {
        if (k == 0) {
            //k==0表示已经找到了k个数字的组合，这时候加入全局result中
            ret.add(new ArrayList(list));
            return;
        } else {
            for (int i = start; i < nums.length; i++) {
                list.add(nums[i]);
                //开始回溯啦，下一次要找的数字减少一个所以用k-1，i+1见后面分析
                backtracking(nums, k - 1, i + 1, list, ret);
                list.remove(list.size() - 1);
            }
        }
    }

}
