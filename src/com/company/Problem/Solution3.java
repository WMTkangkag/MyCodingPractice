package com.company.Problem;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * Created by txk on 2018/8/3.
 * 思路：把链表的值放入一个栈中，然后弹栈把值赋给数组
 */
public class Solution3 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack stack=new Stack<Integer>();
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        while (listNode!=null){
            stack.push(listNode.val);
            listNode=listNode.next;
        }
        while (!stack.isEmpty()){
            arrayList.add((Integer) stack.pop());
        }
        return  arrayList;
    }
}
