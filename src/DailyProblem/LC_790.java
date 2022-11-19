package DailyProblem;

/**
 * 11.12 每日一题
 * 多米诺和托米诺平铺
 */
public class LC_790 {
    static final int MOD = 1000000007;

    /**
     * 动态规划
     * 转至官方题解
     */
    public int numTilings(int n) {
        /**
         *  使用 dp[i][s]表示平铺到第 i列时，各个状态s对应的平铺方法数量
         *  四种状态 s = 0,1,2,3
         *  一个正方形都没有被覆盖，记为状态 0
         * 只有上方的正方形被覆盖，记为状态 1
         * 只有下方的正方形被覆盖，记为状态 2
         * 上下两个正方形都被覆盖，记为状态 3
         */

        int dp[][] = new int[n+1][4];
        dp[0][3] = 1;
        for(int i=1;i<=n;i++){
            dp[i][0] = dp[i-1][3];
            dp[i][1] = (dp[i-1][0] + dp[i-1][2])%MOD;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1])%MOD;
            dp[i][3] = (((dp[i - 1][0] + dp[i - 1][1]) % MOD + dp[i - 1][2]) % MOD + dp[i - 1][3]) % MOD;
        }

        return dp[n][3];
    }
}
