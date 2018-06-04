package com.soufang.other;

import java.util.Arrays;

/**
 * 17 打印从1到最大的n位数
 */
public class PrintNNumbers {
    //第二中方法实现，全排序实现
    public void PrintMaxOfNdigits(int[] number,int length,int index){
        if(index ==length-1){
            PrintNumber(number);
            return;
        }
        for(int i=0;i<10;i++){
            number[index+1]=i;
            PrintMaxOfNdigits(number, length, index+1);
        }
    }

    public void PrintNumber(int[] number){   //该方法是负责打印一个正类，千万不要尝试将数组变成一个整数
        boolean isBeginning=true;
        for(int i=0;i<number.length;i++){
            if(isBeginning&&number[i]!=0)
                isBeginning=false;
            if(!isBeginning){
                System.out.print(number[i]);
            }
        }
    }

    public void printToMax2(int n){
        if(n <= 0) return;
        char[] number = new char[n];
        Arrays.fill(number, '0');
        printOrder(number,n,0);
    }
    public void printOrder(char[] number, int n, int index){
        if(index == n){
            PrintNumber(number);
            return;
        }
        for(int i = 0; i <= 9; i++){
            number[index] = (char)('0' + i);
            printOrder(number,n,index + 1);
        }
    }
    public void PrintNumber(char[] number){
        boolean isBeginning0 = true;
        int length = number.length;
        for (int i = 0; i < length; i++) {
            if(isBeginning0&&number[i]!='0')
                isBeginning0=false;
            if(!isBeginning0){
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PrintNNumbers p = new PrintNNumbers();
        p.printToMax2(2);
    }
}
