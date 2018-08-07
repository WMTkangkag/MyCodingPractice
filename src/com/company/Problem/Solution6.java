package com.company.Problem;

/**
 *题目： 把一个数组最开始的若干个元素搬到数组的末尾， 我们称之数组的旋转。
 * 输入一个递增排序的数组的一个旋转， 输出旋转数组的最小元素。
 * 例如数组{3，4, 5, 1, 2 ｝为｛ l1,2,3, 4，5}的一个旋转，该数组的最小值为1
 * Created by txk on 2018/8/3.
 *
 */
public class Solution6 {

    //思路从头开始遍历数组当遇到第一个不是非减顺序的节点是，这个节点的第二个数一定是最小值，时间复杂度为O（n）
    public int minNumberInRotateArray(int [] array) {
        if(array==null || array.length==0){
            return 0;
        }
        int i=0,j=1,count=0;
        while (array[i]<=array[j] && j<array.length){
            if(array[i]==array[j]){
                count++;
            }
            i++;
            j++;
        }
        if(count==array.length-1 || j==array.length){
            return array[0];
        }
        return array[j];
    }
    //###########################参考答案
    /**
     * 思路：取数组的中间数判断，若中间数大于等于第一个数说明没有问题，问题出在后半部分，
     * 如果
     * */
    public int minNumberInRotateArray1(int [] array) {
        if(array==null || array.length==0){
            return 0;
        }
        int as=0,ae=array.length-1,mid=as;
        while (array[as]>=array[ae]){
            if(ae-as==1){
                return array[ae];
            }
            mid=as+(ae-as)/2;
            if(array[as]==array[mid] && array[mid]==array[ae]){
                return minInorder(array,as,ae);
            }
            if(array[mid]>=array[as]){
                as=mid;
            }else if(array[ae]>=array[mid]){
                ae=mid;
            }
        }
        return array[mid];
    }

    private int minInorder(int[] array,int start,int end){
        int result=array[start];
        for (int i=start+1;i<=end;i++){
            if(result>array[i]){
                result=array[i];
            }
        }
        return result;
    }
}
