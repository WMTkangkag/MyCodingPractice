package com.company.Problem;

import com.company.Solution;

/**
 *题目：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * Created by txk on 2018/8/3.
 * 思路：前序遍历中第一值为根节点，而中序遍历中根节点两边的值分别为左右两颗子树的值，
 * 例如前序遍历的范围是ps....pe 中序遍历的范围是is.....ie
 * 那么ps是根节点，中序遍历中找到值与ps对应相同的值index，则左子树元素个数等于index-is，右子树元素个数为ie-index
 * 那么对应前序遍历的左右子树为 ps+1....ps+index-is , ps+index-is+1.....pe。
 * 然后这两部分的头一个元素又是对应子树的根节点，把该赋值为根节点并且返回
 * 然后又在中序遍历中找出根节点的位置，。。一直递归下去就可以了
 * 当这个ps>pe时递归结束返回null
 */
public class Solution4 {

    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
        }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre==null || in==null || pre.length<1 || pre.length!=in.length){
            return null;
        }
        return  reConstructBinaryTree(pre,in,0,pre.length-1,0,in.length-1);
    }

    private TreeNode reConstructBinaryTree(int[] pre ,int[] in,int ps,int pe,int is,int ie){
        if(ps>pe || is>ie){
            return null;
        }

        TreeNode root=new TreeNode(pre[ps]);

        int index=0;
        for(int i=is;i<=ie;i++){
            if(pre[ps]==in[i]){
                index=i;
            }
        }

        root.left=reConstructBinaryTree(pre,in,ps+1,ps+index-is,is,index-1);
        root.right=reConstructBinaryTree(pre,in,ps+index-is+1,pe,index+1,ie);
        return root;

    }
}
