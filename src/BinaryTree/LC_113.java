package BinaryTree;

import java.util.ArrayList;
import java.util.List;

//路径总和2
public class LC_113
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

    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum)
    {
        if(root==null) return res; //一开始要判空
        traverse(root,targetSum-root.val);
        return res;
    }


    //空节点不进入递归？
    public void traverse(TreeNode node,int count)
    {
        path.add(node.val);
        if(node.left==null&&node.right==null&&count==0)
        {
            res.add(new ArrayList<>(path));
            return;
        }

        if(node.left==null && node.right==null) return;

        if(node.left!=null)
        {
            count -= node.left.val;
           // path.add(node.left.val);
            traverse(node.left,count);
            path.remove(path.size()-1);
            count += node.left.val;
        }

        if(node.right!=null)
        {
            count -= node.right.val;
          //  path.add(node.right.val);
            traverse(node.right,count);
            path.remove(path.size()-1);
            count += node.right.val;
        }
    }



}
