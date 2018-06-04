package com.soufang.other;

/**
 * 62 圆圈中最后剩下的数字
 * 问题描述：n个人（编号0~(n-1))，从0开始报数，报到(m-1)的退出，剩下的人继续从0开始报数。求胜利者的编号。
 * 我们知道第一个被删除的数字是：(m-1)%n ，方便起见，将(m-1)%n 即为K.
 * 那么删除K之后剩下的n-1个数字为：0,1,...,k-1,k+1,...,n-1.下一次从k+1开始，从而形成了：
 *        k+1  k+2  ... n-2, n-1, 0, 1, 2, ... k-1
 * 现在我们把他们的编号做一下转换：
 * k+1   --> 0
 * k+2   --> 1
 * ...
 * ...
 * k-2   --> n-3
 * k-1   --> n-2
 * 把映射定义为p，则p(x) = (x - k -1) % n.则 p^-1(x) = (x+k+1)%n
 * f'(n-1,m) = p^-1[f(n-1,m)] = [f(n-1,m)+k+1]%n, k = (m-1)%n带入，
 * 得到f(n,m) = f'(n-1,m)=[f(n-1,m)+m]%n
 * <p>
 * 递推公式
 * f[1]=0;
 * f[i]=(f[i-1]+m)%i;  (i>1)
 */
public class LastRemaining_Solution {
    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) return -1;
        int last = 0;
        for (int i = 2; i <= n; i++)
            last = (last + m) % i;
        return last;
    }
}
