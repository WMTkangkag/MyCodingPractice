package com.company;

public class Solution {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        //判断输入参数合法性
        if (pre == null || in == null || pre.length != in.length || in.length < 1) {
            return null;
        }
        return construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode construct(int[] pre,int ps,int pe,int[] in,int is,int ie){
        //判断递归结束条件
        if(ps>pe || is>ie){
            return null;
        }
        //去前序遍历第一个元素为根节点
        TreeNode root=new TreeNode(pre[ps]);
        //用index记录中序遍历时根节点在数组中的位置
        int index=0;
        //在中序遍历中寻找到根节点的位置
        for(int i=is;i<=ie;i++){
            if(pre[ps]==in[i]){
                index=i;
            }
        }
        /**
         * 通过递归调用分别获取左子树和右子树
         * 一、左子树对应前序遍历的位置为[ps+1,ps+(index-is)],
         * 对应中序遍历的位置为[is,index-1]
         * 二、右子树对应前序遍历的位置为[ps+index-is+1,pe],
         * 对应中序遍历的位置为[index+1,ie]
        * */
        root.left=construct(pre,ps+1,ps+index-is,in,is,index-1);
        root.right=construct(pre,ps+index-is+1,pe,in,index+1,ie);
        //返回根节点
        return root;
    }
}