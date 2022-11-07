package BinaryTree;

//二叉搜索树中的搜索
public class LC_700
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

    /*
    二叉搜索树是一个有序树
    1. 左子树不空 左子树上所有的值均小于根结点  2. 右子树不空 右子树上所有的值均大于根结点
    3. 平衡二叉搜素树AVL 左右两子树的高度差的绝对值不超过1
     */

    public TreeNode searchBST(TreeNode root, int val)
    {
        if(root==null) return null;
        TreeNode node;
        if(root.val==val) return root;
        else if(val<root.val)
        {
            node = searchBST(root.left,val); //注意到此函数是有返回值的 因此需要有变量获取此返回值
        }else
            node = searchBST(root.right,val);
        return node;
    }
    
    //更简洁的写法
    public TreeNode searchBST2(TreeNode root, int val)
    {
        if(root==null || root.val==val) return root;
        if(val<root.val) return searchBST(root.left,val);
        if(val>root.val) return searchBST(root.right,val);
        return null;
    }
}
