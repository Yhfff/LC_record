package DP.Rober;

import org.omg.CORBA.MARSHAL;

//打家劫舍
public class LC_198 {

    public static void main(String[] args) {
        int nums[] = {2,3,2};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        int len = nums.length;
        /**
         *    dp[i][0]表示不偷窃第i个房屋得到的最高金额
         *    dp[i][1]表示偷窃第i个房屋得到的最高金额
         */
        int dp[][] = new int[len+1][2];

        for(int i=1;i<=len;i++){
            dp[i][0] = Math.max(dp[i-1][1],dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-1][0]+nums[i-1],dp[i][1]);
        }

        return Math.max(dp[len][0],dp[len][1]);
    }

    public int rob2(int[] nums) {
        int len = nums.length;
        if(len==1) return nums[0];
        /**
         *    dp[i]表示偷窃到第i-1个房屋得到的最高金额
         */
        int dp[] = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        for(int i=2;i<len;i++){
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }

        return dp[len-1];
    }
}
