package com.soufang.other;

import java.math.BigInteger;

/**
 * 实现两个大数的加减乘除
 */
public class BigDate {
    private String num1;
    private String num2;
    private String flag = "" ;

    public BigDate(String num1, String num2) {
        int m = 0, n = 0, x = 0, y = 0;
        if (num1.charAt(0) == '-') {   //去掉前面的符号位
            num1 = num1.substring(1);
            x++;
        }
        if (num2.charAt(0) == '-') {
            num2 = num2.substring(1);
            y++;
        }
        //去掉大数前面的无效数字
        while (num1.charAt(m) == '0' && m < num1.length() - 1) {
            m++;
        }
        this.num1 = num1.substring(m);

        while (num2.charAt(n) == '0' && n < num2.length() - 1) {
            n++;
        }
        this.num2 = num2.substring(n);
        if (x + y == 1) {
            this.flag = "-";

        }
    }



    public static void main(String[] args) {
        String num1 = "000000011100000000";
        String num2 = "-0000000022222222222222";
        String res = BigDate.add1(num1, num2);
        System.out.println(res);

        BigInteger num11 = new BigInteger(num1);
        BigInteger num22 = new BigInteger(num2);
        System.out.println(num11.add(num22));
    }

    public static String multiply(String num1, String num2) {
        int m = 0,n = 0, x = 0,y = 0;
        if (num1.charAt(0) == '-') {   //去掉前面的符号位
            num1 = num1.substring(1);
            x++;
        }
        if (num2.charAt(0) == '-') {  //去掉前面的符号位
            num2 = num2.substring(1);
            y++;
        }
        while (num1.charAt(m) == '0' && m < num1.length()-1) { //去掉大数前面的无效数字
            m++;
        }
        num1 = num1.substring(m);
        while (num2.charAt(n) == '0' && n < num2.length()-1) {
            n++;
        }
        num2 = num2.substring(n);

        int length1 = num1.length();
        int length2 = num2.length();
        int[] num = new int[length1 + length2];  //用来存储结果的数组
        for (int i = 0; i < length1; i++) {    //第一个数按位循环
            int n1 = num1.charAt(length1 - 1 - i) - '0';  //得到最低位的数字
            int tmp = 0; //保存进位
            for (int j = 0; j < length2; j++) {  //第二个数按位循环
                int n2 = num2.charAt(length2 - 1 - j) - '0';
                //拿出此时的结果数组里存的数+现在计算的结果数+上一个进位数
                tmp = tmp + num[i + j] + n1 * n2;
                num[i + j] = tmp % 10;   //得到此时结果位的值
                tmp /= 10;   //此时的进位
            }
            num[i + length2] = tmp;  //第一轮结束后，如果有进位，将其放入到更高位
        }
        int i = length1 + length2 - 1;
        while (i > 0 && num[i] == 0) {   //计算最终结果值到底是几位数
            i--;
        }
        StringBuilder result = new StringBuilder();
        while (i >= 0) {   //数组保存的是：12345 ,但其表达的是54321，五万四千三百二十一。
            result.append(num[i--]);
        }
        if (x+y == 1) {
            return  "-"+ result.toString();
        } else {
            return result.toString();
        }
    }


    public static String add1(String num1, String num2){
        int m = 0, n = 0, x = 0, y = 0;
        if (num1.charAt(0) == '-') {   //去掉前面的符号位
            num1 = num1.substring(1);
            x++;
        }
        if (num2.charAt(0) == '-') {
            num2 = num2.substring(1);
            y++;
        }
        //去掉大数前面的无效数字
        while (num1.charAt(m) == '0' && m < num1.length() - 1) {
            m++;
        }
        num1 = num1.substring(m);

        while (num2.charAt(n) == '0' && n < num2.length() - 1) {
            n++;
        }
        num2 = num2.substring(n);

        if (x + y == 2) { //负数减负数
            return "-"+ add(num1, num2);
        } else if( x + y == 1){
            int isBigger = compare(num1, num2);
            if(x+isBigger == 2){
                return "-"+ subtract(num1,num2);
            } else if(x+isBigger ==0){
                return subtract(num2,num1);
            } else if(y+isBigger==0)
                return "-"+ subtract(num2,num1);
            else
                return subtract(num1, num2);
        } else {
            return add(num1, num2);
        }
    }

    /**
     * 比较两个大正数字符串值得大小
     * @param data1
     * @param data2
     * @return
     */
    public static int compare(String data1,String data2){
        if (data1.length() < data2.length()) {
            return -1;
        }else if (data1.length() > data2.length()) {
            return 1;
        }else{
            if (data1.compareTo(data2) > 0) {
                return 1;
            }else if(data1.compareTo(data2) < 0){
                return -1;
            }
        }
        return 1;
    }

    /**
     * 两个正数相加
     * @param num1
     * @param num2
     * @return
     */
    public static String add(String num1, String num2) {
        int length1 = num1.length();
        int length2 = num2.length();
        int len = Math.max(length1, length2);
        int[] num = new int[len + 1]; //用来存储结果的数组
        for (int i = 0; i < len; i++) {  //第一个数按位循环
            int tmp = 0; //保存进位
            int n1 = 0 , n2 = 0;
            if(i < length1)
                n1= num1.charAt(length1 - 1 - i) - '0';  //得到最低位的数字
            if(i < length2)
                n2= num2.charAt(length2 - 1 - i) - '0';  //得到最低位的数字
            tmp = tmp +  n1 + n2;   //拿出此时的结果数组里存的数+现在计算的结果数+上一个进
            num [i] = tmp % 10;   //得到此时结果位的值
            tmp /= 10;   //此时的进位
        }

        StringBuilder result = new StringBuilder();
        while(len > 0 && num[len] == 0)  len -= 1;
        for (int i = len; i >= 0 ; i--) {
            result.append(num[i]);
        }
        return result.toString();
    }

    /**
     * 两个正数相减，且是大数减小数
     * @param num1
     * @param num2
     * @return
     */
    public static String subtract(String num1, String num2) {
        int length1 = num1.length();
        int length2 = num2.length();
        int len = Math.max(length1, length2);

        int[] num = new int[len]; //用来存储结果的数组
        for (int i = 0; i < len; i++) {  //第一个数按位循环
            int tmp = 0; //保存进位
            int n1 = 0 , n2 = 0;
            if(i < length1)
                n1= num1.charAt(length1 - 1 - i) - '0';  //得到最低位的数字
            if(i < length2)
                n2= num2.charAt(length2 - 1 - i) - '0';  //得到最低位的数字
            if(tmp + n1 < n2){
                tmp = tmp +  n1 + 10 - n2;   //拿出此时的结果数组里存的数+现在计算的结果数+上一个进
                num [i] = tmp % 10;   //得到此时结果位的值
                tmp = -1;   //此时的进位
            }else{
                tmp = tmp + n1 - n2;   //拿出此时的结果数组里存的数+现在计算的结果数+上一个进
                num [i] = tmp % 10;   //得到此时结果位的值
                tmp = 0;   //此时的进位
            }

        }
        StringBuilder result = new StringBuilder();
        while(len > 0 && num[len-1] == 0)  len -= 1;
        for (int i = len - 1; i >= 0 ; i--) {
            result.append(num[i]);
        }
        return result.toString();
    }


}
