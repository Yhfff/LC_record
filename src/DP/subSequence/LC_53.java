package DP.subSequence;

/**
 * 最大子数组和
 */
public class LC_53 {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if(len==1) return nums[0];
        int dp[] = new int[len];
        dp[0] = nums[0];
        int res = Integer.MIN_VALUE;
        for(int i=1;i<len;i++){
            dp[i] = Math.max(nums[i],dp[i-1]+nums[i]);
            if(dp[i]>res) res = dp[i];
        }
        return res;
    }
}
