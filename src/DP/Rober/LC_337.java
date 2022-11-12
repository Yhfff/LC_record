package DP.Rober;

/**
 *  打家劫舍3
 *  LC_198 LC_213
 */
public class LC_337 {
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;

         TreeNode() {
         }

         TreeNode(int val) {
             this.val = val;
         }

         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

    /**
     * 树型DP入门题
     * 后序遍历
     */

    public int rob(TreeNode root) {
        int res[] = traverse(root);
        return Math.max(res[0],res[1]);
    }

    /**
     *
     * 一定得是后续遍历
     * 返回值是一个二维数组
     * res[0]表示不偷
     * res[1]表示偷
     */
    public int[] traverse(TreeNode cur){
        int res[] = new int[2];
        if(cur==null) return res;

        //左
        int left[] = traverse(cur.left);
        //右
        int right[] = traverse(cur.right);
        //中
        res[0] = Math.max(left[1],left[0]) + Math.max(right[1],right[0]);  //左+右
        res[1] = cur.val + left[0] + right[0];

        return res;
    }

}
