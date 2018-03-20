package com.soufang.array;

/**
 * 51 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * <p>
 * 思路：
 * //使用归并排序:
 * 归并排序的改进，把数据分成前后两个数组(递归分到每个数组仅有一个数据项)
 * 合并数组，合并时，出现前面的数组值array[i]大于后面数组值array[j]时；
 * 则前面数组array[i]~array[mid]都是大于array[j]的，count += mid+1 - i
 * 还有就是测试用例输出结果比较大，对每次返回的count mod(1000000007)求余
 * <p>
 * //时间复杂度：O(nlogn) 空间复杂度：O(n)
 */
public class InversePairs {

    public int InversePairs(int[] array) {
        if (array == null || array.length == 0) return 0;
        int length = array.length;
        int[] copy = new int[length];
        for (int i = 0; i < length; i++) {
            copy[i] = array[i];
        }
        int count = InversePairsCore(array, copy, 0, length - 1);//数值过大求余
        return count;
    }

    private int InversePairsCore(int[] array, int[] copy, int low, int high) {
        if (low == high) return 0;
        int mid = (low + high) >> 1;
        int leftCount = InversePairsCore(array, copy, low, mid);
        int rightCount = InversePairsCore(array, copy, mid + 1, high);
        int count = 0;
        int i = mid;  //i初始化为前半段最后一个数字的下标
        int j = high; //j初始化为后半段最后一个数字的下标
        int locCopy = high;
        while (i >= low && j > mid) {
            if (array[i] > array[j]) {
                count += j - mid;
                copy[locCopy--] = array[i--];
            } else {
                copy[locCopy--] = array[j--];
            }
        }
        for (; i >= low; i--) {
            copy[locCopy--] = array[i];
        }
        for (; j > mid; j--) {
            copy[locCopy--] = array[j];
        }
        for (int s = low; s <= high; s++) {
            array[s] = copy[s];
        }
        return (leftCount + rightCount + count) % 1000000007;
    }
}
