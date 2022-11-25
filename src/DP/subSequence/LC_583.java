package DP.subSequence;

/**
 * 两个字符串的删除操作
 */
public class LC_583 {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int dp[][] = new int[len1+1][len2+1];
        for(int i=1;i<=len1;i++)
            dp[i][0] = i;
        for(int j=1;j<=len2;j++)
            dp[0][j] = j;
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                /**
                 * 1. 删除word1[i]  dp[i][j] = dp[i-1][j]+1
                 * 2. 删除word2[j]  dp[i][j] = dp[i][j-1]+1
                 * 3. 同时删除word1[i]与word2[j] dp[i][j] = dp[i-1][j-1]+2
                 *                                      = (dp[i-1][j-1]+1) + 1
                 *                                      = dp[i-1][j]/dp[i][j-1] + 1
                 */
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + 1;
            }
        }
        return dp[len1][len2];
    }

    /**
     * 第二种解法
     * 除了最长公共子序列之外的字符都是必须删除的 设长度为n
     * 因此最小的删除次数 = len(word1) + len(word2) - 2 * n
     */

}
