package com.soufang.other;


/**
 * 49 丑数
 * 题目：
 *  把只包含因子2、3和5的数称作丑数（Ugly Number）。习惯上我们把1当做是第一个丑数。
 *  求按从小到大的顺序的第N个丑数。
 * 思路：把找到的丑数都存起来，然后每次都从丑数中去寻找下一个丑数
 *      如果p是丑数，那么p=2^x * 3^y * 5^z，那么只要赋予x,y,z不同的值就能得到不同的丑数。
 *      如果要顺序找出丑数，要知道下面几个特（fei）点（hua）。
         对于任何丑数p：
             （一）那么2*p,3*p,5*p都是丑数，并且2*p<3*p<5*p
             （二）如果p<q, 那么2*p<2*q,3*p<3*q,5*p<5*q
     其实每次我们只用比较3个数：用于乘2的最小的数、用于乘3的最小的数，用于乘5的最小的数。也就是比较(2*x , 3*y, 5*z)
 */
public class GetUglyNumber {
    int GetUglyNumber_Solution(int index) {
        if(index < 0 )        return 0;
        else  if (index < 7)  return index;
        int[] res = new int[index];
        res[0] = 1;
        int t2 = 0, t3 = 0, t5 = 0;
        for (int i = 1; i < index; ++i){
            res[i] = Math.min(res[t2] * 2,  Math.min(res[t3] * 3, res[t5] * 5));
            if (res[i] == res[t2] * 2) t2++;
            if (res[i] == res[t3] * 3) t3++;
            if (res[i] == res[t5] * 5) t5++;
        }
        return res[index - 1];
    }


    public static void main(String[] args) {
        System.out.println(new GetUglyNumber().GetUglyNumber_Solution(10));
    }
}
