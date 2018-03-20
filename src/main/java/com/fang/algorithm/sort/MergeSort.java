package com.fang.algorithm.sort;

/**
 * 归并排序(Merge Sort)
 * 归并排序的实现分为递归实现与非递归(迭代)实现。
 * 递归实现的归并排序是算法设计中分治策略的典型应用，我们将一个大问题分割成小问题分别解决，然后用所有小问题的答案来解决整个大问题。
 * 非递归(迭代)实现的归并排序首先进行是两两归并，然后四四归并，然后是八八归并，一直下去直到归并了整个数组。
 * <p>
 * 申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
 * 设定两个指针，最初位置分别为两个已经排序序列的起始位置
 * 比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
 * 重复步骤3直到某一指针到达序列尾
 * 将另一序列剩下的所有元素直接复制到合并序列尾
 */
public class MergeSort {
    // 分类 -------------- 内部比较排序
    // 数据结构 ---------- 数组
    // 最差时间复杂度 ---- O(nlogn)
    // 最优时间复杂度 ---- O(nlogn)
    // 平均时间复杂度 ---- O(nlogn)
    // 所需辅助空间 ------ O(n)
    // 稳定性 ------------ 稳定


    void Merge(int A[], int left, int mid, int right) { // 合并两个已排好序的数组A[left...mid]和A[mid+1...right]
        int len = right - left + 1;
        int[] temp = new int[len];       // 辅助空间O(n)
        int index = 0;
        int i = left;                   // 前一数组的起始元素
        int j = mid + 1;                // 后一数组的起始元素

        // 把较小的数先移到新数组中
        while (i <= mid && j <= right) {
            temp[index++] = A[i] <= A[j] ? A[i++] : A[j++];  // 带等号保证归并排序的稳定性
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[index++] = A[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= right) {
            temp[index++] = A[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int k = 0; k < len; k++) {
            A[left++] = temp[k];
        }
    }

    void MergeSortRecursion(int A[], int left, int right) {   // 递归实现的归并排序(自顶向下)
        if (left == right)    // 当待排序的序列长度为1时，递归开始回溯，进行merge操作
            return;
        int mid = (left + right) / 2;
        MergeSortRecursion(A, left, mid);  // 左边
        MergeSortRecursion(A, mid + 1, right); // 右边
        Merge(A, left, mid, right); // 左右归并
    }

    void MergeSortIteration(int A[], int len)  {    // 非递归(迭代)实现的归并排序(自底向上)
        int left, mid, right;// 子数组索引,前一个为A[left...mid]，后一个子数组为A[mid+1...right]
        for (int i = 1; i < len; i *= 2)  {       // 子数组的大小i初始为1，每轮翻倍
            left = 0;
            while (left + i < len)  {             // 后一个子数组存在(需要归并)
                mid = left + i - 1;
                right = mid + i < len ? mid + i : len - 1;// 后一个子数组大小可能不够
                Merge(A, left, mid, right);
                left = right + 1;               // 前一个子数组索引向后移动
            }
        }
    }

    public static void main(String[] args) {
        int[] A= { 6, 5, 3, 1, 8, 7, 2, 4 };// 从小到大二分插入排序
        int left = 0;
        int right = A.length;
        new MergeSort().MergeSortRecursion(A, left, right);
    }
}
