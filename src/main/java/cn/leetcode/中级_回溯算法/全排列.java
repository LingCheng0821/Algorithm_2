package cn.leetcode.中级_回溯算法;

import cn.leetcode.StringUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Laura on 2018/5/30.
 * 全排列
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * 输入:
 *      [1,2,3]
 * 输出:
 * [
     *  [1,2,3],
     *  [1,3,2],
     *  [2,1,3],
     *  [2,3,1],
     *  [3,1,2],
     *  [3,2,1]
 * ]
 */
public class 全排列 {
    @Test
    public void test(){
        int[] numbs = {1,2,3};
        List<List<Integer>> result = permute(numbs);
        new StringUtil<Integer>().print(result);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0 )  return res;

        ArrayList<Integer> list = new ArrayList<>();
        dfs(res, list, nums);
        return res;
    }
    private void dfs(List<List<Integer>> res, ArrayList<Integer> list, int[] nums) {
        int n = nums.length;
        if(list.size() == n) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0;i < n;i++) {
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            dfs(res, list, nums);
            list.remove(list.size() - 1);
        }
    }

}

