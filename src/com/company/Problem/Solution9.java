package com.company.Problem;

/**
 * 题目：一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * Created by txk on 2018/8/6.
 */
public class Solution9 {

    public int JumpFloorII(int target) {

        if(target==0){
            return 1;
        }
        if(target==1){
            return 1;
        }

        int sum=0;
        for (int i=1;i<=target;i++){
            sum+=JumpFloorII(target-i);
        }

        return sum;
    }


}
