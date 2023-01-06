package Offer;

/**
 * 二叉树的镜像
 */
public class Offer_27 {
     public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
     }

    /**
     * 首先明确遍历顺序
     * 前后序都可以 中序不行
     */
    // 前序遍历
    public TreeNode mirrorTree(TreeNode root) {
         if(root == null) return null;
         changeNode(root); //中
         mirrorTree(root.left); // 左
         mirrorTree(root.right); // 右
         return root;
    }

    public void changeNode(TreeNode node){
         TreeNode tmp = node.left;
         node.left = node.right;
         node.right =tmp;
    }
}
