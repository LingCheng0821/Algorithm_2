package com.soufang.other;

import java.text.DecimalFormat;

/**
 * Created by Laura on 2018/3/12.
 */
public class Power {
    public double Power(double base, int exponent) {
        int exponentAbs =  Math.abs(exponent);
        if(Double.compare(base, 0) == 0 && exponent < 0) {
            //base=0，指数为负数，需要对0求导
            throw new RuntimeException("has error");
        }
        double result = PowerWithUnsignedExponent(base, exponentAbs);
        if(exponent < 0)
            result = 1.0 / result;
        return result;
    }
    public double PowerWithUnsignedExponent(double base, int exponent) {
//        if(exponent == 0)
//            return 1;
//        if(exponent == 1)
//            return base;
//        double result = PowerWithUnsignedExponent(base, exponent>>1);
//        result *= result;
//        if((exponent & 0x1) == 1)
//            result *= base;
//        return result;
        double r = 1.0;
        while(exponent!=0){
            if((exponent&1)==1)
                r *= base;
            base *= base;  // 翻倍
            exponent>>=1;  // 右移一位
        }
        return r;

    }

    public static void main(String[] args) {
        DecimalFormat df   = new DecimalFormat("######0.00");
        int days = 31;
        double money;
        double sum = 0.0;
        for (int i = 0; i < days; i++) {
            money = 0.01 * Math.pow(2.0, i);
            sum = Double.valueOf(df.format(sum + money));
            System.out.println("i=" + (i+1) + ", money=" + money + ", sum = " + sum);
        }

    }
}
