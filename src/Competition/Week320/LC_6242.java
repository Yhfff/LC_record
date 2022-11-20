package Competition.Week320;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树最近节点查询
 */
public class LC_6242 {
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

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp;
        for(int i=0;i<queries.size();i++){
            temp = searchTree(root,queries.get(i));
            res.add(temp);
        }
        return res;
    }

    public List<Integer> searchTree(TreeNode root,int val){
        /**
         * min为小于等于val的最大值
         * max为大于等于val的最小值
         */
        int min = Integer.MIN_VALUE,max=Integer.MAX_VALUE;
        List<Integer> temp = new ArrayList<>();
        while(root!=null){
            if(root.val==val) {
                temp.add(val);
                temp.add(val);
                return temp;
            }else if(root.val>val){ //root的值大于val 搜索root的左边
                if(root.left!=null)
                {
                    root = root.left;
                    min =  Math.max(min,root.val);
                }
            }else {//root的值小于val
                if(root.right!=null){
                    root = root.right;
                    max = Math.min(max,root.val);
                }
            }
        }
        if(min==Integer.MIN_VALUE){
            temp.add(-1);
        }else
            temp.add(min);
        if(max==Integer.MAX_VALUE){
            temp.add(-1);
        }else
            temp.add(max);
        return temp;

    }




}
