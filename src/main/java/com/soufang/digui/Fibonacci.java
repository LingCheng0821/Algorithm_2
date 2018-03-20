package com.soufang.digui;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。n<=39
 */
public class Fibonacci {

    public int solution(int n) {
        int fibonacciRuselt = 0;
        int fibonacciOne = 0;
        int fibonacciTwo = 1;
        if(n == 0 || n == 1)
            return n;
        for (int i = 2; i <= n; i++) {
            fibonacciRuselt = fibonacciOne + fibonacciTwo;
            fibonacciOne = fibonacciTwo;
            fibonacciTwo = fibonacciRuselt;
        }
        return fibonacciRuselt;
    }
}
