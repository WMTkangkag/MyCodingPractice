package com.company.Problem;

/**
 * 题目：给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * Created by txk on 2018/8/7.
 */
public class Solution12 {

    //算法并不好，时间复杂度为O(exponent)
    public double Power(double base, int exponent) {

        if(exponent==0){
            return 1;
        }
        if(exponent==1){
            return base;
        }
        boolean flag=false;
        if(exponent<0){
            exponent=-exponent;
            flag=true;
        }
        double ret=1;
        for(int i=1;i<=exponent;i++){
            ret*=base;
        }
        if(flag){
            ret=1/ret;
        }
        return ret;
    }
////参考答案
    //用递归的方法能少算很多次
    public double Power2(double base, int exponent) {

        //判断exponent是否为负数
        boolean flag=false;
        if(exponent==0){
            return 1;
        }
        if(exponent<0){
            exponent=-exponent;
            flag=true;
        }
        double ret=curPower2(base,exponent);
        if(flag){
            ret = 1/ret;
        }
        return ret;
    }

    private double curPower2(double base,int exponent){


        if(exponent==1){
            return base;
        }
        //算一半的值
        double ret=curPower2(base ,exponent >> 1);

        ret*=ret;
        //若为奇数还要补乘一次base
        if(exponent%2==1){
            ret*=base;
        }
        return ret;

    }
}
