package DP.CompleteBag;

import java.util.Arrays;

/**
 * 完全平方数
 * 与LC_322几乎一模一样
 */
public class LC_279 {

    public int numSquares(int n) {
        /**
         * dp[i]表示和为n的完全平方数的个数
         */
        int dp[] = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i=1;i*i<=n;i++){
            for(int j=1;j<=n;j++){
                if(j>=i*i && dp[j-i*i]!=Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j],dp[j-i*i] + 1);
                }
            }
        }
        return dp[n];
    }
}
