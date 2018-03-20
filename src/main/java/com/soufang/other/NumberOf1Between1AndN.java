package com.soufang.other;

/**
 * 43 1~n整数中1出现的次数
 * 分析：
 *  从 1 至 10，在它们的个位数中，任意的 X 都出现了 1 次。
 *  从 1 至 100，在它们的十位数中，任意的 X 都出现了 10 次。
 *  从 1 至 1000，在它们的千位数中，任意的 X 都出现了 100 次。
 *  依此类推，从 1 至 10i，在它们的左数第二位（右数第 i 位）中，任意的 X 都出现了 10i−1 次。
 *
 * 主要思路：
 *  设定整数点（如1、10、100等等）作为位置点i（对应n的各位、十位、百位等等），分别对每个数位上有多少包含1的点进行分析
 *  根据设定的整数位置，对n进行分割，分为两部分，高位n/i，低位n%i
 *     当i表示百位，且百位对应的数>=2,如n=31456,i=100，则a=314,b=56，
 *            此时百位为1的次数有a/10+1=32（最高两位0~31），每一次都包含100个连续的点，即共有(a%10+1)*100个点的百位为1
 *     当i表示百位，且百位对应的数为1，如n=31156,i=100，则a=311,b=56，
 *            此时共有a%10(最高两位0-30)次是包含100个连续点，
 *            当最高两位为31，本次只对应局部点00~56，共b+1次，所有点加起来共有（a%10*100）+(b+1)，这些点百位对应为1
 *     当i表示百位，且百位对应的数为0,如n=31056,i=100，则a=310,b=56，此时百位为1的次数有a/10=31（最高两位0~30）
 * //综合以上三种情况，当百位对应0或>=2时，有(a+8)/10次包含所有100个点，还有当百位为1(a%10==1)，需要增加局部点b+1
 * //之所以补8，是因为当百位为0，则a/10==(a+8)/10，当百位>=2，补8会产生进位位，效果等同于(a/10+1)
 */
public class NumberOf1Between1AndN {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int i = 1; i <= n; i *= 10) {
            //i表示当前分析的是哪一个数位
            int a = n / i, b = n % i;
            int temp = a % 10 == 1 ? 1 : 0;
            count = count + (a + 8) / 10 * i + temp * (b + 1);
        }
        return count;
    }
    public int NumberOf1Between1AndN_Solution(int n, int x) {
        int count = 0;

        for (int i = 1; i <= n; i *= 10) {
            //i表示当前分析的是哪一个数位
            int high = n / i;
            int b = n % i;

            int temp = high % 10 == x ? 1 : 0;
            count = count + (high + (9-x)) / 10 * i + temp * (b + 1);
        }
        return count;
    }

    public int count(int n, int x) {
        int count = 0;
        for (int i = 1; i <= n;i *= 10) {
            int high = (n / i) / 10;  // 高位的数字。
            int cur =  (n / i) % 10;  // 当前位的数字。
            if (x == 0) {
                if (high != 0) {
                    high--;
                } else {
                    break;
                }
            }
            count += high * i;

            if (cur > x) {
                count += i;
            } else if (cur == x) {
                count += n -  (n / i) * i + 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 100, x = 0;
        int res = new NumberOf1Between1AndN().NumberOf1Between1AndN_Solution(n, x);
        int result = new NumberOf1Between1AndN().count(n, x);
        System.out.println("res = " + res);
        System.out.println("result = " + result);
    }
}

