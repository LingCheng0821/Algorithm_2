package cn.leetcode.中级_排序和搜索;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Laura on 2018/6/4.
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-medium/50/sorting-and-searching/98/
 *
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *      输入: [3,2,1,5,6,4] 和 k = 2
 *      输出: 5
 *
 * 示例 2:
 *      输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 *      输出: 4
 *
 * 说明:
 *      你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class 第K个最大元素 {

    @Test
    public void test(){
        int[] nums = {1};
        int k = 1;
        System.out.println(findKthLargest(nums, k));

    }

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < 1 || k < 1)  return 0;
        return QuickSort(nums, 0, nums.length - 1, k);
    }
    void Swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    int QuickSort(int nums[], int left, int right, int k) {
        if (left > right)  return 0;
        int pivot_index = Partition(nums, left, right); // 基准的索引
        if(pivot_index == k-1) return nums[pivot_index];
        else if(pivot_index < k-1 ){
            return  QuickSort(nums, pivot_index + 1, right, k);
        }else {
            return QuickSort(nums, left, pivot_index - 1, k);
        }
    }

    // 划分函数
    int Partition(int nums[], int left, int right) {
        int pivot = nums[left];               // 这里每次都选择最后一个元素作为基准
        int start = right + 1;                   // tail为小于基准的子数组最后一个元素的索引
        for (int i = right; i > left; i--) {	// 遍历基准以外的其他元素
            if (nums[i] <= pivot) {	// 把小于等于基准的元素放到前一个子数组末尾
                Swap(nums, --start, i);
            }
        }
        Swap(nums, start - 1, left);  //把基准放到前一个子数组的后边，剩下的是大于基准的子数组
        return start - 1;                    // 返回基准的索引
    }

    // 划分函数:从小到大
//    int Partition(int A[], int left, int right) {
//        int pivot = A[right];               // 这里每次都选择最后一个元素作为基准
//        int tail = left - 1;                // tail为小于基准的子数组最后一个元素的索引
//        for (int i = left; i < right; i++) { 	// 遍历基准以外的其他元素
//            if (A[i] <= pivot) {	// 把小于等于基准的元素放到前一个子数组末尾
//                Swap(A, ++tail, i);
//            }
//        }
//        Swap(A, tail + 1, right);  //把基准放到前一个子数组的后边，剩下的是大于基准的子数组
//        return tail + 1;                    // 返回基准的索引
//    }




//    public int findKthLargest(int[] nums, int k) {
//        if(nums == null || nums.length < 1 || k < 1)
//            return 0;
//
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1.compareTo(o2);
//            }
//        });
//
//        for (int i = 0; i < nums.length; i++) {
//            if(maxHeap.size() != k){
//                maxHeap.add(nums[i]);
//            } else if(maxHeap.peek() < nums[i]){
//                maxHeap.poll();
//                maxHeap.offer(nums[i]);
//            }
//        }
//        return maxHeap.peek();
//    }
}
