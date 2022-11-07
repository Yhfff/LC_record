package BinaryTree;

import java.util.ArrayList;
import java.util.List;

//二叉树的所有路径
public class LC_257
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

    //递归
    public List<String> binaryTreePaths(TreeNode root)
    {
        List<String> res = new ArrayList<>();
        if(root==null) return res;
        List<Integer> path = new ArrayList<>();
        traversal(root,path,res);
        return res;
    }

    //path用来存放节点 但存放至res中 需要处理一下
    //前序遍历
    public void traversal(TreeNode node, List<Integer> path, List<String> res)
    {
       path.add(node.val);
       //遇到叶子节点
        if(node.left==null && node.right==null)
        {
            StringBuilder sb = new StringBuilder(); //使用StringBuilder
            for(int i=0;i<path.size()-1;i++)
            {
                sb.append(path.get(i)).append("->");
            }
            sb.append(path.get(path.size()-1));
            res.add(sb.toString());
            return;
        }

        //左
        if(node.left!=null)
        {
            traversal(node.left,path,res);
            path.remove(path.size()-1);//回溯
        }

        //右
        if(node.right!=null)
        {
            traversal(node.right,path,res);
            path.remove(path.size()-1);//回溯
        }
    }

}
