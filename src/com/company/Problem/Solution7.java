package com.company.Problem;

/**
 *题目：大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39
 * Created by txk on 2018/8/6.
 */
public class Solution7 {

    public int Fibonacci(int n) {

        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return Fibonacci(n-1)+Fibonacci(n-2);

    }

}
