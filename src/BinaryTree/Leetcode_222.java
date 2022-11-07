package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

//完全二叉树的节点个数
public class Leetcode_222
{
    public class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val=val;}
        TreeNode(int val, TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    //递归
    public int countNodes_2(TreeNode root)
    {
        return getCnt(root);
    }

    public int getCnt(TreeNode node)
    {
        if(node==null) return 0; //孩子节点数量为0
        int left = getCnt(node.left); //左
        int right = getCnt(node.right);//右
        return 1 + left + right;//记得加1 中
    }


    //利用满二叉树的特性  单个节点也为满二叉树
    public int countNodes_3(TreeNode root)
    {
        if(root==null) return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftDepth = 0,rightDepth=0; //当leftDepth==rightDepth时 说明是满二叉树 可用公式计算
        while(left!=null)
        {
            left = left.left;
            leftDepth++;
        }
        while(right!=null)
        {
            right = right.right;
            rightDepth++;
        }
        if(leftDepth==rightDepth)
            return (2<<leftDepth)-1;// 2<<1 相当于2^2 因此设置初始leftDepth为1  使用位运算
        return countNodes_3(root.left) + countNodes_3(root.right) + 1;//记得+1
    }




    //层次遍历
    public int countNodes(TreeNode root)
    {
        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<>(); //队列接口是LinkedList

        if(root!=null) queue.add(root);

        while(!queue.isEmpty())
        {
            int size = queue.size();
            //借助一个for循环完成一层一层的操作 循环次数就是队列里面的元素个数
            for(int k=1;k<=size;k++)
            {
                TreeNode node = queue.poll();
                ans++;
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
        }

        return ans;

    }
}
