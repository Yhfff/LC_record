package BinaryTree;


import java.util.ArrayList;
import java.util.List;

//验证二叉搜索树
public class LC_98
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
    利用二叉搜索树的特性 前序遍历 如果是一个递增序列 那么就是一个二叉搜索树 否则就不是
     */
    List<Integer> list = new ArrayList<>();

    public boolean isValidBST(TreeNode root)
    {
       if(root==null) return true;
       traverse(root);
       for(int i=1;i<list.size();i++)
       {
           if(list.get(i)<=list.get(i-1))
               return false;
       }
       return true;
    }

    public void traverse(TreeNode node)
    {
        if(node==null) return;
        traverse(node.left); //左
        list.add(node.val);  //中
        traverse(node.right); //右
    }

    /*
    不需要提前定义list  可以边遍历边比较
     */
    TreeNode temp; //记录前一个节点
    public boolean isValidBST2(TreeNode root)
    {
        if(root==null) return true;
        boolean left = isValidBST2(root.left); //左

        if(temp!=null && temp.val >= root.val) return false; //中
        temp = root;

        boolean right = isValidBST2(root.right); //右

        return left&&right;
    }




    /*
     此题不能单纯地递归判断节点的左子树的val小于节点的val 右子树节点的val大于节点的val
     需要的是左子树所有节点的val小于根结点的val
     */
    public boolean judge(TreeNode node)
    {
        if(node.left==null && node.right==null) return true;
        if(node.left!=null && node.left.val>=node.val) return false;
        if(node.right!=null && node.right.val<=node.val) return false;

        //会有空指针异常
        return judge(node.left) && judge(node.right);
    }

}
