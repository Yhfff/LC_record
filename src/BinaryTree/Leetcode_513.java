package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

//找树左下角的值
public class Leetcode_513
{
    public class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val=val;}
        TreeNode(int val, TreeNode left,TreeNode right)
        {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    //最底层 最左边
    //迭代 层次遍历
    public int findBottomLeftValue(TreeNode root)
    {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root!=null) queue.add(root);
        int result = 0;
        //如何判断是最后一层
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i=0;i<size;i++)
            {
                TreeNode node = queue.poll();
                if(i==0) result = node.val; //不断访问每一行的第一个元素 最后的赋值就是最后一行的第一个元素
                if(node.left!=null)queue.add(node.left);
                if(node.right!=null)queue.add(node.right);
            }
        }
        return result;
    }

    //递归
//    public int findBottomLeftValue_2(TreeNode root)
//    {
//
//    }


}
