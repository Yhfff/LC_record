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

    /**
     * 利用二叉搜索树的特性
     * 中序遍历转成有序数组 然后在数组中进行二分查找
     */
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        traverse(root);
        int len = list.size();
//        int nums[] = new int[len];
//        for(int i=0;i<len;i++){
//            nums[i] = list.get(i);
//        }
        //开始查找
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<queries.size();i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(findLeftMax(queries.get(i)));
            temp.add(findRightMin(queries.get(i)));
            ans.add(temp);
        }
        return ans;
    }

    //中序遍历
    public void traverse(TreeNode root){
        if(root==null) return;
        traverse(root.left); //左
        list.add(root.val); //中
        traverse(root.right);//右
    }

    //二分 查找小于等于target的最大值
    public int findLeftMax(int target){
        int left = 0;
        int right = list.size()-1;
        while(left<right){
            //why right-left+1
            int mid = left + (right-left+1)/2;
            if(list.get(mid)>target){
                //往左找 [0,mid-1]找
                right = mid-1;

            }else {//nums[mid]<=target
                //往右找 [mid,length-1]
                left = mid;
                //System.out.println(left);
            }
        }
        return list.get(left)<=target?list.get(left):-1;
    }


    //查找大于等于target的最小值
    public int findRightMin(int target){
        int left = 0;
        int right = list.size()-1;//[0,length-1]查找
        while(left<right){
            //这种写法是防止溢出
            int mid = left + (right-left)/2;
            if(list.get(mid)<target){
                //往右找 [mid+1,length-1]查找 因为mid肯定不符合
                left = mid+1;
            }else { //nums[mid]>=target  有可能等于 所以mid不能舍去
                //往左找[0,mid]
                right=mid;
            }
        }
        return list.get(left)>=target?list.get(left):-1;
    }

}
