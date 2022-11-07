package BinaryTree;

//最大二叉树
public class LC_654
{
    public class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val=val;}
        TreeNode(int val, TreeNode left,TreeNode right)
        {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums)
    {
        return constructMaximumBinaryTree1(nums,0,nums.length);
    }

    //使用数组构造二叉树时，每次分割尽量不要定义新的数组，而是通过下标索引直接在原数组上进行操作，这样可以节约时间和空间上的开销
    //分割数组秉持左闭右开的原则 保持循环不变量
    public TreeNode constructMaximumBinaryTree1(int[] nums,int left,int right)
    {
        if(right-left<1) //没有元素
            return null;
        if(right-left==1)//刚好有一个元素
            return new TreeNode(nums[left]);

        //寻找最大值的下标
        int maxIndex = left;
        int maxVal = nums[maxIndex];
        for(int i=left;i<right;i++)
        {
            if(nums[i]>maxVal)
            {
                maxIndex = i;
                maxVal = nums[i];
            }
        }

        TreeNode root = new TreeNode(maxVal);
        //左闭右开 [left,maxIndex)
        root.left = constructMaximumBinaryTree1(nums,left,maxIndex);
        //左闭右开 [maxIndex+1,right)
        root.right = constructMaximumBinaryTree1(nums,maxIndex+1,right);//left应该==maxIndex+1 nums[maxIndex]不能再使用了

        return root;
    }
}
