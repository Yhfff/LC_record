package BinaryTree;

import java.util.*;

//对称二叉树
public class LC_101
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


    public boolean isSymmetric(TreeNode root)
    {
        //1<=node<=100
        if(root==null)
            return true;
        return judge(root.left,root.right);
    }

    //递归 有返回值的递归 之前递归的返回值是void
    public boolean judge(TreeNode node1,TreeNode node2)
    {
        //递归终止条件  处理(排除)空节点的情形 如果不排除的话 后续取值操作可能会有空指针异常
        if(node1==null && node2==null) return true;
        else if(node1!=null && node2==null) return false;
        else if(node1==null && node2!=null) return false;
        else if(node1.val!=node2.val) return false; //此时node1与node2肯定不为空

        //单层循环逻辑
        boolean left = judge(node1.left,node2.right);  //判断外侧
        boolean right = judge(node1.right,node2.left);  //判断内侧
        return left&&right;
    }

    //迭代 Stack or Queue 都可
    public boolean isSymmetric_2(TreeNode root)
    {
       if(root==null) return true;
       //ArrayDeque<TreeNode> deque = new ArrayDeque<>();
       Queue<TreeNode> deque = new LinkedList<>();
       deque.add(root.left);
       deque.add(root.right);
       while (!deque.isEmpty())
       {
           //弹出两个元素用作比较
           TreeNode left = deque.poll();
           TreeNode right = deque.poll();

           //判断空节点的情况
           if(left==null && right==null) //如果两个都为空
               continue;//此时不能直接返回true
           // 此时一定至少有一个不为空
           if(left==null || right==null || (left.val!=right.val))
               return false;

           //一定要注意添加的顺序
           deque.offer(left.left); //左子树的左节点
           deque.offer(right.right); //右子树的右节点
           deque.offer(left.right);// 左子树的右节点
           deque.offer(right.left);//右子树的左节点
       }
       return true;
    }

}


