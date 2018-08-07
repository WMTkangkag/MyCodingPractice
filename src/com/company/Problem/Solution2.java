package com.company.Problem;

/**
 * 题目：请实现一个函数，把字符串中的每个空格替换成"%20"，例如“We are happy.”，则输出“We%20are%20happy.”。
 * Created by txk on 2018/8/3.
 */
public class Solution2 {

    public String replaceSpace(StringBuffer str) {

       return str.toString().replaceAll(" " , "%20");
    }
  //##################################参考答案########################
    /**
     * 思路：把stringbuffer转换为字符数组charArray，遍历字符数组统计空白字符数量count
     * 然后新建一个字符数组newCharArray大小为老的字符数组个数+2*count
     * 然后从头到尾遍历老的字符数组，如果没有碰到空格字符就把原来的字符赋值给新的字符数组newCharArray
     * */
    public String replaceSpace2(StringBuffer str){
        if(str==null){
            return null;
        }
        int count=0;
        char[] charArray = str.toString().toCharArray();
        for(int i=0;i<charArray.length;i++){
            if(charArray[i]==' '){
                count++;
            }
        }
        char[] newCharArray=new char[charArray.length+2*count];
        int count1=0;
        for(int i=0;i<charArray.length;i++){
            if(charArray[i]!=' '){
                newCharArray[i+2*count1]=charArray[i];
            }else {
                newCharArray[i+2*count1]='%';
                newCharArray[i+2*count1+1]='2';
                newCharArray[i+2*count1+2]='0';
                count1++;
            }
        }
        return newCharArray.toString();
    }
}
