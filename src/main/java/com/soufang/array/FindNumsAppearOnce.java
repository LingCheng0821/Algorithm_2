package com.soufang.array;

/**
 * 56 数组中数字出现的次数
 */
public class FindNumsAppearOnce {
    /**
     * 题目：一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
     * 时间复杂度为：O(n)，将num1[0],num2[0]设置为返回结果
     * <p>
     * 思路：位运算中异或的性质：两个相同数字异或=0，一个数和0异或还是它本身。
     * ① 首先从头到尾异或数组中的每个数字，那么最终得到的结果就是两个只出现一次的数字的异或结果。
     * ② 然后在结果数字钟找到第一个为1的位的位置，即为第n位，将第n为是不是1分为两个子数组；
     * ③ 然后然后在异或每个数组，得到结果即为只出现一次的数字
     */
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array == null || array.length < 2)
            return;
        int resultExclusiveOR = 0;
        for (int i = 0; i < array.length; i++)
            resultExclusiveOR ^= array[i];
        int indexOf1 = FindFirstBitIs1(resultExclusiveOR);

        for (int i = 0; i < array.length; i++) {
            if (isBit(array[i], indexOf1))
                num1[0] ^= array[i];
            else
                num2[0] ^= array[i];
        }
    }


    public int FindFirstBitIs1(int num) {
        int indexBit = 0;
        while (((num & 1) == 0) && (indexBit) < 8 * 4) {
            num = num >> 1;
            ++indexBit;
        }
        return indexBit;
    }

    public boolean isBit(int num, int indexBit) {
        num = num >> indexBit;
        return (num & 1) == 1;
    }

    /**
     * 题目二：除一个数字只出现一次之外，其他数字都出现了三次，请找出这个数字。
     * 思路：将为禁止表示的每一位都加起来，
     * 如果某一位的和能被3整除，那么那个只出现一次的数字二进制中对应的哪一位是0，其他为1.
     */
    public int   FindNumsAppearOnce(int[] array) {
        if (array == null || array.length < 2)
            return -1;
        int[] bitSum = new int[32];
        for (int i = 0; i < array.length; i++) {
            int bitMask = 1;
            for (int j = 31; j >= 0 ; j--) {
                int bit = array[i] & bitMask;
                if(bit != 0)
                    bitSum[j] += 1;
                bitMask = bitMask << 1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            result += bitSum[i] % 3;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,1,2,3,1,2,3,5};
        int  res = new FindNumsAppearOnce().FindNumsAppearOnce(array);
        System.out.println(res);
    }

}
