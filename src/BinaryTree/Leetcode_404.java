package BinaryTree;

import java.util.Stack;

//左叶子之和
public class Leetcode_404
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

    public int sumOfLeftLeaves(TreeNode root)
    {
        return getLeft(root);
    }

    //不能直接判断这个节点是不是左叶子节点 只能通过节点的父节点来判断其左孩子是不是左叶子节点
    public int getLeft(TreeNode node)
    {
        if(node==null) return 0; //没有左子树
        if(node.left==null && node.right==null) return 0;//叶子节点的左子树为空

        int left = getLeft(node.left);

        if(node.left!=null && node.left.left==null && node.left.right==null) //这个判断条件很关键
            left = node.left.val;  //这样就能确保是左边的叶子节点
        int right = getLeft(node.right);

        int sum = left + right;
        return sum;
    }

//    public int getLeft(TreeNode node,int ans)
//    {
//        if(node==null) return 0; //没有左子树
//
//        int left = getLeft(node.left,ans);
//
//        int right = getLeft(node.right,ans);
//
//        if(node.left==null && node.right==null) //遇到左叶子节点 处理
//            ans += node.val;
//        return ans;
//    }

    //迭代
    public int sumOfLeftLeaves_2(TreeNode root)
    {
        Stack<TreeNode> stack = new Stack<>();
        int ans = 0;
        if(root!=null) stack.push(root);
        while(!stack.isEmpty())
        {
            TreeNode node = stack.pop();

            if(node.left!=null && node.left.left==null && node.left.right==null)
                ans += node.left.val;

            if(node.right!=null) stack.push(node.right); //先右后左
            if(node.left!=null) stack.push(node.left);
        }
        return ans;
    }


}
