package com.company.Problem;

/**
 * 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * Created by txk on 2018/8/3.
 */
public class Solution1 {

    public boolean Find(int target, int[][] array) {
        //输入条件判断，除去为空的条件
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }
        //获取行和列的数量
        int row = array.length;
        int col = array[0].length;
        for (int i = 0; i < row; i++) {
            //除去两边的条件
            if (array[i][0] == target) {
                return true;
            } else if (array[i][col - 1] == target) {
                return true;
            } else if (target > array[i][0] && target < array[i][col - 1]) {
                if(binarySearch(array, i, 1, col - 1, target)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean binarySearch(int[][] array,int row,int l,int r,int target){
        if(l>r){
            return false;
        }
        int mid=l+(r-l)/2;
        if(array[row][mid]==target){
            return true;
        }else if(array[row][mid]>target){
           return binarySearch(array,row,l,mid-1,target);
        }else{
            return binarySearch(array,row,mid+1,r,target);
        }

    }
//####################################################################
    /*参考答案,首先选取数组中右上角的数字。如果该数字等于要查找的数字，查找过程结束：
     如果该数字大于要查找的数字，剔除这个数字所在的列：如果该数字小于要查找的数字，剔除这个数字所在的行。
     也就是说如果要查找的数字不在数组的右上角，则每－次都在数组的查找范围中剔除）行或者一列，这样每一步都可以缩小
     查找的范围，直到找到要查找的数字，或者查找范围为空*/
    public boolean Find1(int target, int[][] array) {
        if(array == null || array.length == 0 || array[0].length == 0){
            return false;
        }
        //行数和列数
        int rows=array.length;
        int cols=array[0].length;
        //启始的行数和列数
        int row=0;
        int col=cols-1;

        while (row>=0 && row<rows && col>=0 && col<cols){
            if(array[row][col]==target){
                return true;
            }
            if(array[row][col]<target){
                row++;
            }else {
                col--;
            }
        }
        return false;
    }


}


