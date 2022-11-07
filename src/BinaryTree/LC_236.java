package BinaryTree;

import sun.reflect.generics.tree.Tree;

//二叉树的最近公共祖先
public class LC_236
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

    /**
     * 自底向上 -》回溯 -》 后序遍历
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root==p || root==q) return root;

        TreeNode left = lowestCommonAncestor(root.left,p,q);//左
        TreeNode right = lowestCommonAncestor(root.right,p,q);//右

        //中
        if(left!=null && right!=null) return root;
        else if(left!=null && right==null) return left;  //左子树不为空 右子树为空 返回左子树
        else if(left==null && right!=null) return right;
        else return null;
    }

}
