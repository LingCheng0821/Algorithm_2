package com.fang;

import java.util.Scanner;

/**
 * 输入一个正整数n,求n!(即阶乘)末尾有多少个0？
 * 比如: n = 10; n! = 3628800,所以答案为2
 * 解题思路：两个大数字相乘，都可以拆分成多个质数相乘，而质数相乘结果尾数为0的，只可能是2*5。两个数相乘尾数0的个数其实就是依赖于2和5因子的个数。
 *         又因为每两个连续数字就会有一个因子2，个数非常充足，所以此时只需要关心5因子的个数就行了。
 *
 *         令n! = (5*K) * (5*(K-1)) * (5*(K-2)) * ... * 5 * A，其中A就是不含5因子的数相乘结果，n = 5*K + r（0<= r <= 4）。
 *         假设f(n!)是计算阶乘n!尾数0的个数，而g(n!)是计算n!中5因子的个数，那么就会有如下公式：
 *              f(n!) = g(n!) = g(5^K * K! * A) = K + g(K!) = K + f(K!)，其中K=n / 5（取整数）。
 *              很显然，当0 <= n <= 4时，f(n!)=0。结合这两个公式，就搞定了这个问题了。
 * 例如：f(1000!) = 200 + f(200!) = 200 + 40 + f(40!) = 240 + 8 + f(8!) = 248 + 1 + f(1) =249
 */
public class 末尾0的个数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(numOf0(n));
    }
    public static int numOf0(int n){
        int result = 0;
        while(n >= 5){
            result += n / 5;
            n = n / 5;
        }
        return result;
//        if(n < 5)
//            return 0;
//        else
//            return n/5 + numOf0(n/5);

    }
}
