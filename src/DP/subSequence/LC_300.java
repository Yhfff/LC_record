package DP.subSequence;

import java.util.Arrays;

/**
 * 最长递增子序列
 * 子序列在原序列中不一定是连续的
 */
public class LC_300 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len==1) return 1;
        //dp[i]表示以第i个元素结尾的递增子序列的最长长度
        int dp[] = new int[len];
        int res = 0;
        Arrays.fill(dp,1);
        for(int i=1;i<len;i++){
            //需要与i之前的所有元素都要比较
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j])
                    dp[i] = Math.max(dp[i],dp[j]+1);
            }
            if(dp[i]>res) res = dp[i];
        }
        return res;
    }
}
