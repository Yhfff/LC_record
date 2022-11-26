package DP.subSequence;

/**
 * 编辑距离
 * 可与LC_583比较：只能删除操作
 * 但这一题不仅可以删除 还可以插入与替换
 */
public class LC_72 {
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
                 * 1. 删除操作：  [0,i-2] 与[0,j-1]匹配
                 *    删除word1中第i-1和字符 dp[i-1][j] + 1 +1为删除操作
                 * 2. 插入操作：
                 *     dp[i][j-1] + 1
                 * 3. 替换操作： [0,i-2] 与 [0,j-2]匹配
                 *    替换  dp[i-1][j-1] + 1
                 */
                dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
            }
        }
        return dp[len1][len2];
    }
}
