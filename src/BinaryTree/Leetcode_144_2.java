package BinaryTree;

import java.util.*;

//二叉树的前中后序遍历 迭代  层次遍历(BFS)
public class Leetcode_144_2
{
    public class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val=val;}
        TreeNode(int val,TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }
    //前序遍历 迭代 父->左->右
    //访问顺序和处理顺序是一致的
    public static List<Integer> preorderTraversal(TreeNode root)
    {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if(root==null) return null;
        stack.push(root);
        while (!stack.isEmpty())
        {
            TreeNode temp = stack.pop();
            ans.add(temp.val);
            if(temp.right!=null) stack.push(temp.right);//先将右孩子入栈 但前提不能为空
            if(temp.left!=null) stack.push(temp.left);//再将左孩子入栈
        }

        return ans;
    }


    //统一风格的迭代写法
    //标记法 添加空节点
    public static List<Integer> inorderTraversal_2(TreeNode root)
    {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root!=null) stack.push(root);

        while (!stack.isEmpty())
        {
           TreeNode node = stack.pop();
           if(node!=null)
           {
               /*
               要想换中序 后序的算法 只需要改变这部分代码即可 调整顺序
               中：左父右 -》 右父左
               前：父左右 -》 右左父
               后：左右父 -》 父右左
                */
               if(node.right!=null) stack.push(node.right);//右
               stack.push(node);//中
               //添加一个空节点
               stack.push(null);
               if(node.left!=null) stack.push(node.left);//左
           }else//遇到空节点
           {
               node = stack.pop();
               ans.add(node.val);
           }
        }
        return ans;
    }


    //中序遍历 迭代
    public static List<Integer> inorderTraversal(TreeNode root)
    {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root==null) return null;
        TreeNode cur = root;  //一直往左子树探
        while (!stack.isEmpty() || cur!=null)
        {
            if(cur!=null)
            {
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();//左
                ans.add(cur.val);
                cur = cur.right; //右
            }
        }
        return ans;
    }



    //后序遍历 迭代 与前序比较
    public static List<Integer> postTraversal(TreeNode root)
    {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if(root==null) return null;
        stack.add(root);
        while (!stack.isEmpty())
        {
            TreeNode temp = stack.pop();
            ans.add(temp.val);
            if(temp.left!=null) stack.push(temp.left);//先将左孩子入栈 但前提不能为空
            if(temp.right!=null) stack.push(temp.right);//再将右孩子入栈
        }
        Collections.reverse(ans); //需要反转
        /*
         前序：父-》左-》右
            父-》左-》右   -》 父-》右-》左  reverse  -> 左-》右-》父
         后序：左-》右-》父
         */
        return ans;
    }

    //层次遍历 使用队列
    public List<List<Integer>> levelOrder(TreeNode root)
    {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>(); //对列接口是LinkedList

        if(root!=null) queue.add(root);

        while(!queue.isEmpty())
        {
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            //借助一个for循环完成一层一层的操作 循环次数就是队列里面的元素个数
            for(int k=1;k<=size;k++)
            {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            ans.add(list);
        }

        return ans;

    }





}
