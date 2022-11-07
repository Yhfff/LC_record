package BinaryTree;


import java.util.LinkedList;
import java.util.Queue;

//合并二叉树
public class LC_617
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

    //前中后均可以  只需调整root1.val += root2.val的位置  只是前序最符合理解
    //两颗二叉树的遍历是同步进行的 不是异步

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2)
    {
        //这里没有判断root1与root2同时为空的情况 因为没有必要 两个同时为空 最后返回的也是空
        if(root1==null) return root2;
        if(root2==null) return root1;
        //这里直接修改root1 也可以定义一个新节点
        root1.val += root2.val; //中
        root1.left = mergeTrees(root1.left,root2.left);//左
        root1.right = mergeTrees(root1.right,root2.right);//右
        return root1;

        /*
        //定义新节点
        TreeNode root = new TreeNode(0);
        root.val = root1.val + root2.val;
        root.left = mergeTrees(root1.left,root2.left);//左
        root.right = mergeTrees2(root1.right,root2.right);//右
        return root;
        */
    }

    //迭代
    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2)
    {
        if(root1==null) return root2;
        if(root2==null) return root1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root1);
        queue.add(root2);
        //队列均空时 跳出循环
        while (!queue.isEmpty())
        {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            //此时两个节点肯定不为空
            node1.val += node2.val;
            //两个节点的左子树都不为空 加入队列
            if(root1.left!=null && root2.left!=null)
            {
                queue.offer(root1.left);
                queue.offer(root2.left);
            }
            //两个节点的右子树都不为空 加入队列
            if(root1.right!=null && root2.right!=null)
            {
                queue.offer(root1.right);
                queue.offer(root2.right);
            }
            //对root1考虑
            if(root1.left==null && root2.left!=null)
                root1.left = root2.left;
            if(root1.right==null && root2.right!=null)
                root1.right = root2.right;
        }
        return root1;
    }
}
