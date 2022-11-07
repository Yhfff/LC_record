package DP;

//最大子数组和
public class LC_53
{
    public static void main(String[] args) {
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }


    //动态规划
    public static int maxSubArray(int[] nums)
    {
        int len = nums.length;
        //dp[i]表示以i结尾的最长子数组和
        int dp[] = new int[len];
        dp[0] = nums[0];
        //int max = Integer.MIN_VALUE;
        int max = dp[0];
        for(int i=1;i<len;i++)
        {
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            if(dp[i]>max) max = dp[i];
        }
        return max;

    }
}
