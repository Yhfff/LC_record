package BinaryTree;

import java.util.ArrayList;
import java.util.List;

//二叉搜索树的最小绝对差
public class LC_530
{
    public class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val=val;}
        TreeNode(int val, TreeNode left, TreeNode right)
        {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<Integer> list = new ArrayList<>();
    public int getMinimumDifference2(TreeNode root)
    {
        int minDiff = Integer.MAX_VALUE;
        traverse2(root);
        for(int i=1;i<list.size();i++)
        {
            int temp = list.get(i) - list.get(i-1);
            minDiff = temp<minDiff?temp:minDiff;
        }
        return minDiff;
    }

    public void traverse2(TreeNode node)
    {
        if(node==null) return;
        traverse2(node.left); //左
        list.add(node.val);  //中
        traverse2(node.right); //右
    }

    //边遍历边比较
    //至少两节点
    int res = Integer.MAX_VALUE;
    TreeNode pre = null; //记录前一个节点
    public void traverse(TreeNode cur)
    {
        if(cur==null) return;
        traverse(cur.left); //左

        if(pre!=null)
            res = (cur.val- pre.val)<res?(cur.val- pre.val):res;//中
        pre = cur;

        traverse(cur.right);
    }


    public int getMinimumDifference(TreeNode root)
    {
        traverse(root);
        return res;
    }
}
