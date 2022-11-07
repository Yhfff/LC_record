package DP;

//摆动序列 也可用贪心算法求解
public class LC_376
{
    public static void main(String[] args)
    {
       // int[] nums = {1,17,5,10,13,15,10,5,16,8};
        int[] nums = {0,0};
        System.out.println(wiggleMaxLength_dp(nums));
    }

    //动态规划 DP
    public static int wiggleMaxLength_dp(int[] nums)
    {
        int len = nums.length;
        /*
        dp[i][0]: 以i结尾的 且第i个元素为山峰的最长长度
        dp[i][1]: 以i结尾的 且第i个元素为山谷的最长长度
         */
        int dp[][] = new int[len][2];
        //dp[0][0] = dp[0][1] = 1;
        for(int i=0;i<len;i++)
        {
            dp[i][0] = dp[i][1] = 1;
            for(int j=0;j<i;j++)
            {
                if(nums[i]>nums[j])
                    dp[i][0] = Math.max(dp[i][0],dp[j][1]+1);

                if(nums[i]<nums[j])
                    dp[i][1] = Math.max(dp[i][1],dp[j][0]+1);
            }
        }
        return Math.max(dp[len-1][0],dp[len-1][1]);
    }
}
