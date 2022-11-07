package BinaryTree;
//平衡二叉树
public class LC_110
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

    public boolean isBalanced(TreeNode root)
    {
        return getHeight2(root)==-1?false:true;
    }

//    public boolean balance(TreeNode node)
//    {
//        if(node==null) return true;
//        int left = getHeight(node.left);//获得左子树的高度
//        int right = getHeight(node.right);//获得右子树的高度
//        if(Math.abs(left-right)>1) return false;
//        return balance(node.left) && balance(node.right);
//
//
//    }

    public int getHeight2(TreeNode node)
    {

        if(node==null) return 0; // 为什么返回0 是因为空节点的高度是0
        int leftLength = getHeight2(node.left);  //左
        if(leftLength==-1) return -1;  //这个不能省略
        int rightLength = getHeight2(node.right); //右
        if(rightLength==-1) return -1;

        if(Math.abs(leftLength-rightLength)>1)  //由于返回值是整型 所以不能直接返回true or false 选择返回-1
            return -1;
        else
            return 1 + Math.max(leftLength,rightLength);
    }

    //依旧是要求高度 如果不是平衡二叉树 返回-1
    public int getHeight(TreeNode node)
    {
        if(node==null) return 0; // 为什么返回0 是因为空节点的高度是0
        int leftLength = getHeight(node.left);  //左
        if(leftLength == -1) return -1;
        int rightLength = getHeight(node.right); //右
        if(rightLength == -1) return -1;
        //如果不是二叉树 返回-1
        return Math.abs(leftLength-rightLength)>=1?-1:1+Math.max(leftLength,rightLength);
    }


}
