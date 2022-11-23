package BinarySearch;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * LC_6242的一个子问题
 * 二分
 */
public class LC_34 {
    //二分 O(logn)
    public static int[] searchRange(int[] nums, int target) {
        if(nums.length==0) return new int[]{-1,-1};
        int left = 0,right = nums.length-1;
        int res[] = new int[2];
        //查找左边界
        while(left<right){
            int mid = left + (right-left)/2;
            if(nums[mid]>=target){
                right = mid;  //收缩右边界
            }else {
                left = mid + 1; //更新left之前[0,mid]肯定<target
            }
        }
        if(nums[left]!=target) return new int[]{-1,-1};
        res[0] = left;
        left = 0;
        right = nums.length-1;
        //查找右边界
        while(left<right){
            int mid = left + (right-left+1)/2;
            if(nums[mid]<=target){
                left = mid;//扩大左边界
            }else {
                right = mid - 1;
            }
        }
        res[1] = left;
        return res;
    }


    //暴力 O(n)
    public int[] searchRange2(int[] nums, int target) {
        int res[] = new int[2];
        int left = -1;
        int right = -1;
        boolean flag = false;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==target && !flag)
            {
                left = i;
                flag = true;
            }
            if(nums[i]==target && flag){
                right = i;
            }
        }
        res[0] = left==-1?-1:left;
        res[1] = right==-1?-1:right;
        return res;
    }

    public static void main(String[] args) {
        int nums[] = {5,7,7,8,8,10};
        int target = 6;
        int res[] = searchRange(nums,target);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
