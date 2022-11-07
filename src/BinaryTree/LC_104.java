package BinaryTree;


import java.util.LinkedList;
import java.util.Queue;

//二叉树的最大深度
public class LC_104
{
    public class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val=val;}
        TreeNode(int val,TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    public int maxDepth(TreeNode root)
    {
//        if(root==null) return 0;
//        int leftMaxDepth = goDeep(root.left);
//        int rightMaxDepth = goDeep(root.right);
//        return 1 + Math.max(leftMaxDepth,rightMaxDepth);
        return getHeight(root);
    }

    //递归
//    public int goDeep(TreeNode node, int depth)
//    {
//        //递归终止条件
//        if(node==null) return 0;
//        //单层循环逻辑
//        int left = 0;
//        int right = 0;
//        if(node.left!=null) left = goDeep(node.left,depth+1);
//        if(node.right!=null) right = goDeep(node.right,depth+1);
//        return Math.max(left,right);
//    }
    public int getHeight(TreeNode node)
    {
        /*
        后序遍历(左右中) 求的是高度
        前序遍历(中左右) 求的是深度
        此题采用的是后序遍历 因为根节点的高度就是树的最大深度
         */
        if(node==null) return 0; // 为什么返回0 是因为空节点的高度是0
        int leftLength = getHeight(node.left);  //左
        int rightLength = getHeight(node.right); //右
        int depth = 1 + Math.max(leftLength,rightLength);  //需要加1 例如往下探两次 但其实最大深度是3 中(处理逻辑)

        //可以简化成 return 1 + Math.max( getHeight(node.left), getHeight(node.right));
        return depth;
    }

    //迭代 使用层序遍历
    public int maxDepth_2(TreeNode root)
    {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root!=null) queue.offer(root);
        int maxDepth = 0;  //层数就是最大深度 不需要设置初始值1

        while (!queue.isEmpty())
        {
            int size = queue.size();

            for(int i=0;i<size;i++)
            {
                TreeNode node = queue.poll();
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
//                if(node==null)
//                {
//
//                    continue;
//                }
//                if(node.left!=null && node.right==null)
//                {
//                    queue.add(node.left);
//                    queue.add(null);
//                }
//                else if(node.right!=null && node.left==null)
//                {
//                    queue.add(node.right);
//                    queue.add(null);
//                }else if(node.right!=null && node.left!=null)
//                {
//                    queue.add(node.left);
//                    queue.add(node.right);
//                    queue.add(null);
//                }


            }
            maxDepth+=1;
        }

        return maxDepth;
    }



}
