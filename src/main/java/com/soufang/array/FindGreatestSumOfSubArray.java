package com.soufang.array;

/**
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 算法时间复杂度O（n）
        用curSum记录累计值，greatestSum记录和最大
 基于思想：对于一个数A，若是A的左边累计数非负，那么加上A能使得值不小于A，认为累计值对
           整体和是有贡献的。如果前几项累计值负数，则认为有害于总和，total记录当前值。
 此时 若和大于maxSum 则用maxSum记录下来
 */
public class FindGreatestSumOfSubArray {
    public int findGreatestSumOfSubArray(int[] array) {
        if (array==null || array.length==0)
            return 0;

        int curSum = array[0], greatestSum = array[0]; //注意初始值 不能设为0 防止只有负数
        for (int i = 1; i < array.length; i++) {

            if (curSum<=0) {
                curSum=array[i]; //记录当前最大值
            }else {
                curSum+=array[i]; //当array[i]为正数时，加上之前的最大值并更新最大值。
            }
            if (curSum>greatestSum) {
                greatestSum=curSum;
            }
        }
        return greatestSum;
    }

    public static void main(String[] args) {
        int[] array = {1,-2,3,10,-4,7,2,-5};
        System.out.println(new FindGreatestSumOfSubArray().findGreatestSumOfSubArray(array));
    }
}
