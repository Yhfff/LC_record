package BinaryTree;

/**
 * 二叉搜索树的最近公共祖先
 * 可以LC_236比较
 */
public class LC_235
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
     *二叉搜素树是有序的
     * p,q公共祖先的val   p.val < ancestor.val < q.val
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root.val>p.val && root.val>q.val)
            return lowestCommonAncestor(root.left,p,q);
        else if(root.val<p.val && root.val<q.val)
            return lowestCommonAncestor(root.right,p,q);
        else return root;
    }
}
