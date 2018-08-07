package com.company.Problem;

import java.util.Stack;

/**
 * 题目：用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * Created by txk on 2018/8/3.
 * 思路：stack1用于入队，当需要出队的时候判断stack2是否为空不为空的话先把以前的值出队，
 * 如果为空这个时候把stack1的全部出栈放到stack2。
 */
public class Solution5 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
       return stack2.pop();
    }

}
