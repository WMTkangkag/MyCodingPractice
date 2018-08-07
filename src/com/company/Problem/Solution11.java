package com.company.Problem;

/**
 * 题目：输入一个整数，输出该数二进制表示中1的个数。
 * 其中负数用补码表示。
 * Created by txk on 2018/8/6.
 */
public class Solution11 {

    //参考答案

    /**
     * 思路：通过n=(n-1)&n 每一次与操作n最右边的1就变为0，
     * 直到n为0结束，这时候就可以通过一个变量记录与操作的次数就可以
     * 得出1的个数
     * （负数的二进制数是补码）
     * @param n
     * @return
     */
    public int NumberOf1(int n) {
        int result=0;
        while (n!=0){
            n=n&(n-1);
            result++;
        }
        return result;
    }

}
