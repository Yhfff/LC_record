package DP.subSequence;

import sun.nio.cs.ext.MacThai;

import java.util.Arrays;

/**
 * 最长连续递增序列
 * 与LC_300比较
 */
public class LC_674 {
    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        //dp[i]：以下标i为结尾的数组的连续递增的子序列长度
        int dp[] = new int[len];
        int res = 1;
        Arrays.fill(dp,1);
        for(int i=1;i<len;i++){
            //由于连续 因此不需要for循环 直接if
            if(nums[i]>nums[i-1])
                dp[i] = dp[i-1]+1;
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
