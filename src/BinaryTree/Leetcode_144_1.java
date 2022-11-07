package BinaryTree;

import java.util.ArrayList;
import java.util.List;

//二叉树的前中后序遍历 递归
public class Leetcode_144_1
{
    public class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val=val;}
        TreeNode(int val,TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }
    //前序遍历 递归
    public static List<Integer> preorderTraversal(TreeNode root)
    {
        List<Integer> ans = new ArrayList<>();
        preOrder(root,ans);
        return ans;
    }

    public static void preOrder(TreeNode node,List<Integer> ans) //递归参数
    {
        //递归终止条件
        if(node==null) return;
        //单层递归逻辑
        ans.add(node.val);
        preOrder(node.left,ans);
        preOrder(node.right,ans);
    }


    //中序遍历 递归
    public static List<Integer> inorderTraversal(TreeNode root)
    {
        List<Integer> ans = new ArrayList<>();
        inOrder(root,ans);
        return ans;
    }

    public static void inOrder(TreeNode node,List<Integer> ans) //递归参数
    {
        //递归终止条件
        if(node==null) return;
        //单层递归逻辑
        inOrder(node.left,ans);
        ans.add(node.val);
        inOrder(node.right,ans);
    }

    //后序遍历 递归
    public static List<Integer> postTraversal(TreeNode root)
    {
        List<Integer> ans = new ArrayList<>();
        postOrder(root,ans);
        return ans;
    }

    public static void postOrder(TreeNode node,List<Integer> ans) //递归参数
    {
        //递归终止条件
        if(node==null) return;
        //单层递归逻辑
        postOrder(node.left,ans);
        postOrder(node.right,ans);
        ans.add(node.val);
    }

}
