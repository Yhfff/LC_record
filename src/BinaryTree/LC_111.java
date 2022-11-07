package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

//二叉树的最小深度
public class LC_111
{
    public class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val=val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }



    // 迭代 使用层序遍历
    public int minDepth(TreeNode root)
    {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root!=null) queue.offer(root);
        int minDepth = 0;  //层序遍历 不需要设置初始值1

        while (!queue.isEmpty())
        {
            int size = queue.size();

            for(int i=0;i<size;i++)
            {
                TreeNode node = queue.poll();
                //如果遇到叶子节点(左右孩子为空) 直接return
                if(node.left==null && node.right==null) return minDepth+1;

                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            minDepth+=1;
        }
        return minDepth;
    }

    // 递归
    public int minDepth_2(TreeNode root)
    {
        return goDeep(root);
    }

    //后序遍历 求的是高度
    public int goDeep(TreeNode node)
    {
        if(node==null) return 0;

        int left = goDeep(node.left); //左
        int right = goDeep(node.right); //右

        //判断左右子树为空的逻辑
        if(node.left==null && node.right!=null) //此时并不是最低点 右子树不为空 1+右子树的高度
            return 1 + right;
        if(node.right==null && node.left!=null)
            return 1 + left;
        return 1 + Math.min(left,right);
    }


}
