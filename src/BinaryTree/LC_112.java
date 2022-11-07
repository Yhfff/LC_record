package BinaryTree;
//路径总和
public class LC_112
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

    public boolean hasPathSum(TreeNode root, int targetSum)
    {
        if(root==null) return false;
        return hasPathSum(root,targetSum-root.val);
    }

    //精简后的代码
    public boolean hasPathSum_2(TreeNode root,int targetSum)
    {
        if(root==null) return false;
        //不仅和为0 而且要到达叶子节点
        if(root.left==null && root.right==null && targetSum==0) return true;
        //遇到叶子节点 直接返回
        if(root.left==null && root.right==null) return false;
        return hasPathSum_2(root.left,targetSum-root.left.val) ||
                hasPathSum_2(root.right,targetSum-root.right.val);
    }


    //不需要处理中间节点
    public boolean traverse(TreeNode node,int count)
    {
        //不仅和为0 而且要到达叶子节点
        if(node.left==null && node.right==null && count==0) return true;
        //遇到叶子节点 直接返回
        if(node.left==null && node.right==null) return false;

        if(node.left!=null)
        {
            count -= node.left.val;
            traverse(node.left,count);
            count += node.left.val; //回溯
        }
        if(node.right!=null)
        {
            count += node.right.val;
            traverse(node.right,count);
            count -= node.right.val; //回溯
        }
        return false;
    }

}
