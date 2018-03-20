package com.fang.other;

import java.util.Scanner;

/**
 * 一本算法书一共有n页，页码从1到n。
 * 在这本算法书页码中0~9每个数字分别出现了多少次？
 * 输入描述:：输入包括一个整数n(1 ≤ n ≤ 1,000,000,000)
 * 输出描述:输出包括一行10个整数，即0~9这些数字在页码中出现的次数，以空格分隔。行末无空格。
 * 解题思路：分析1的个数
 * 分析一位数的情况：
 * if(N >= 1) f(N) = 1  else f(N)=0
 * 分析两位数的情况：
 * 个位：
 * if(个位数 >= 1) f(N)=十位数字+1； else f(N) = 十位数字
 * 即： if(N % 10 >= 1) f(N)=N/10+1; else f(N)=N/10;
 * <p>
 * 十位：
 * if(十位数 > 1) f(N)=10 else if(十位数==1) f(N) = 个位数字+1 else 0
 * 即： if(N /10 > 1) f(N)=10 else if(N/10 == 1) f(N)=N%10+1 else 0
 * <p>
 * 分析三位数：
 * 个位：if(N % 100 >= 1) f(N)=N/10 + 1; else f(N)=N/10;
 * 十位：if(N/10 %10 >1) f(N)=20 else if(N/10%10 == 1) f(N)=N%10+11 else 10
 * 百位：if(N /100 > 1) f(N)=100 else if(N/100 == 1) f(N)=N%10+1 else 0
 */
public class counteach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < 9; i++) {
            System.out.print(counteach(N, i)+ " ");
        }
        System.out.print(counteach(N, 9));
    }

    //统计数字i出现个数
    public static int counteach(int n, int i) { //n=123 i =1
        int iCount = 0;
        int iFactor = 1;
        int iLowerNum = 0;
        int iCurrNum = 0;
        int iHigherNum = 0;

        while (n / iFactor != 0) {
            iLowerNum = n - (n / iFactor) * iFactor;    //个位数
            iCurrNum = (n / iFactor) % 10;              //iCurrNum=个位数 iCurrNum=3
            iHigherNum = n / (iFactor * 10);            //iHigherNum=12

            if (iCurrNum < i)
                iCount += iHigherNum * iFactor;
            else if (i == iCurrNum)
                iCount += iHigherNum * iFactor + iLowerNum + 1;
            else if (iCurrNum > i)
                iCount += (iHigherNum + 1) * iFactor;
            //处理0的个数
            //若n为1位数，比如本来是1 2 3 4 5 6 ，之前处理成 0 1 2 3 4 5 6,多加了1个0
            //若n为2位数，比如本来是1 2 3 4 5 6 7 8 9 10 11 12，之前处理成 00 01 02 ...09 10 11 12,多加了1+10个0
            //若n为3位数，比如本来是1 2 3 4 ... 115，之前处理成000 001 002 ...009 010 011...099 100...115，多加了1+10+100个0
            //因此需要在每层循环中减去多计算的0的个数
            if (0 == i)
                iCount -= iFactor;

            iFactor *= 10;
        }
        return iCount;
    }
}
