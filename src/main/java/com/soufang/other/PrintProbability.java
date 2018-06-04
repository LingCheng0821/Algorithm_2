package com.soufang.other;

/**
 * 60 N个骰子的点数
 * 思路：N个，最小为n,最大为6N，所以开辟index=6N的数组
 * 我们需要将中间值存起来以减少递归过程中的重复计算问题，可以考虑我们用两个数组AB，
 * A在B之上得到，B又在A之上再次得到，这样AB互相作为对方的中间值
 * 我们用一个flag来实现数组AB的轮换，由于要轮转，我们最好声明一个二维数组，
 * 这样的话，如果flag=0时，1-flag用的就是数组1，如果flag=1时，1-flag用的就是数组0,
 */
public class PrintProbability {
    private static final int g_maxValue = 6;

    //基于循环求骰子点数
    public void PrintProbability_Solution(int n) {
        if (n < 1) return;

        int probability = g_maxValue * n;

        int[][] pProbabilities = new int[2][probability + 1];

        for (int i = 0; i <= probability; i++) { //初始化数组
            pProbabilities[0][i] = 0;
            pProbabilities[1][i] = 0;
        }
        int flag = 0;
        //当第一次抛掷骰子时，有6种可能，每种可能出现一次
        for (int i = 1; i <= g_maxValue; i++) {
            pProbabilities[flag][i] = 1;
        }
        //从第二次开始掷骰子，假设第一个数组中的第n个数字表示骰子和为n出现的次数，
        //在下一循环中，我们加上一个新骰子，此时和为n的骰子出现次数应该等于上一次循环中骰子点数和为n-1,n-2,n-3,n-4,n-
        //n-6的次数总和，所以我们把另一个数组的第n个数字设为前一个数组对应的n-1,n-2,n-3,n-4,n-5，n-6之和
        for (int k = 2; k <= n; k++) {
            for (int i = 0; i < k; i++) {//第k次掷骰子，和最小为k，小于k的情况是不可能发生的！所以另不可能发生的次数设置为0！
                pProbabilities[1 - flag][i] = 0;
            }
            for (int i = k; i <= g_maxValue * k; i++) {//第k次掷骰子，和最小为k，最大为g_maxValue*k
                pProbabilities[1 - flag][i] = 0;//初始化，因为这个数组要重复使用，上一次的值要清0
                for (int j = 1; j <= i && j <= g_maxValue; j++) {
                    pProbabilities[1 - flag][i] += pProbabilities[flag][i - j];
                }
            }
            flag = 1 - flag;
        }
        double total = Math.pow(g_maxValue, n);
        for (int i = n; i <= g_maxValue * n; i++) {
            String ratio = "" + pProbabilities[flag][i] + "/" + total;
            System.out.println("sum: " + i + " ratio: " + ratio);
        }

    }

    public static void main(String[] args) {
        new PrintProbability().PrintProbability_Solution(2);

    }
}
