package cn.leetcode.中级_排序和搜索;

import org.junit.Test;

import java.util.*;

/**
 * Created by Laura on 2018/6/4.
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/50/sorting-and-searching/97/
 *
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 例如：给定数组 [1,1,1,2,2,3] , 和 k = 2，返回 [1,2]。
 * 注意：
 *      你可以假设给定的 k 总是合理的，1 ≤ k ≤ 数组中不相同的元素的个数。
 *      你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 */
public class TopK次数 {

    @Test
    public void test(){
        int[] nums = {1,1,1,2,2,3};
        int k =2;
        System.out.println(topKFrequent(nums, k));
    }
    class FEntity {
        private Integer key;
        private Integer value;
        public FEntity(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
        public Integer getKey() {
            return key;
        }
        public void setKey(Integer key) {
            this.key = key;
        }
        public Integer getValue() {
            return value;
        }
        public void setValue(Integer value) {
            this.value = value;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if(nums == null || nums.length < 1 || k < 1)
            return Collections.emptyList();

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        int key;
        for (int i = 0; i < nums.length; i++) {
            key = nums[i];
            int count = map.get(key) == null ? 1 : map.get(key)+1;
            map.put(key, count);
        }

        PriorityQueue<FEntity> maxHeap = new PriorityQueue<FEntity>(k, new Comparator<FEntity>() {
            @Override
            public int compare(FEntity o1, FEntity o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        for (Integer var : map.keySet()) {
            FEntity entity = new FEntity(var, map.get(var));
            if (maxHeap.size() != k) {
                maxHeap.offer(entity);
            } else if (maxHeap.peek().getValue() < map.get(var)) {
               maxHeap.poll();
               maxHeap.offer(entity);
            }
        }

        for (FEntity var : maxHeap) {
            result.add(var.getKey());
        }

        return result;

    }
}
