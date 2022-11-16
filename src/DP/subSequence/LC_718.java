package DP.subSequence;

/**
 * 最长重复子数组
 * 子数组是连续的
 */
public class LC_718 {

    public int findLength(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        //dp[i][j] 表示num1[:i]与nums2[:j]的最长重复子数组
        int dp[][] = new int[len1+1][len2+1];
        int res = 0;
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(nums1[i-1] == nums2[j-1])
                    dp[i][j] = dp[i-1][j-1] + 1;
                res = Math.max(res,dp[i][j]);
            }
        }
        return res;
    }
}
