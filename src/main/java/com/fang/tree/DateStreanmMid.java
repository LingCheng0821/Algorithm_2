package com.fang.tree;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 解题思路：
 *  (1)没有排序的数组:
 *      插入的时间复杂度：O(1)   查找中位数的时间复杂度：O(n)
 *  (2)排序的数组：
 *      插入的时间复杂度：O(n)   查找中位数的时间复杂度：O(1)
 *  (3)排序的链表
 *      插入的时间复杂度：O(n)   查找中位数的时间复杂度：O(1)
 *  (4)二叉搜索树
 *      插入的时间复杂度：平均O(logn)，最差O(n)
 *      查找中位数的时间复杂度：平均O(logn)，最差O(n)
 *  (4)AVL
 *      插入的时间复杂度：O(logn)   查找中位数的时间复杂度：O(1)
 *  (5)最大堆和最小堆
 *      插入的时间复杂度：O(logn)   查找中位数的时间复杂度：O(1)
 *  具体思路：
 *      用一个最大堆实现左边的数据容器，用最小堆实现右边的数据容器。
 *      首先要保证数据平均分配到两个堆中：在数据的总数目是偶数时把新数据插入到最小堆中，否则插入到最大堆中
 *      最大堆中里的所有数据都要小于最小堆中的数据：先把新的数据插入到最大堆中，接着把最大堆中的最大的数字拿出来插入到最小堆中
 */
public class DateStreanmMid {

    private int count = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 11;

    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(DEFAULT_INITIAL_CAPACITY, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    public void Insert(Integer num) {
        if (count %2 == 0) { //当数据总数为偶数时，新加入的元素，应当进入小根堆
            //（注意不是直接进入小根堆，而是经大根堆筛选后取大根堆中最大元素进入小根堆）
            //1.新加入的元素先入到大根堆，由大根堆筛选出堆中最大的元素
            maxHeap.offer(num);
            int filteredMaxNum = maxHeap.poll();
            //2.筛选后的【大根堆中的最大元素】进入小根堆
            minHeap.offer(filteredMaxNum);
        } else {
            //当数据总数为奇数时，新加入的元素，应当进入大根堆
            //（注意不是直接进入大根堆，而是经小根堆筛选后取小根堆中最大元素进入大根堆）
            //1.新加入的元素先入到小根堆，由小根堆筛选出堆中最小的元素
            minHeap.offer(num);
            int filteredMinNum = minHeap.poll();
            //2.筛选后的【小根堆中的最小元素】进入大根堆
            maxHeap.offer(filteredMinNum);
        }
        count++;
    }

    public Double GetMedian() {
        if (count %2 == 0) {
            return new Double((minHeap.peek() + maxHeap.peek())) / 2;
        } else {
            return new Double(minHeap.peek());
        }
    }


}
