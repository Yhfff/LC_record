package DP.Stock;

/**
 * 买卖股票的最佳时机II
 * 1. 在任何时候最多只能持有一股股票，也可以先购买，然后在同一天出售
 * 2. 可以有多笔交易
 */
public class LC_122 {
    public int maxProfit(int[] prices) {
        /**
         * dp[i][0]表示第i天持有股票所得最多现金
         * dp[i][1]表示第i天没有股票所得最多现金
         */
        int len = prices.length;
        int dp[][] = new int[len][2];

        dp[0][0] -= prices[0];//说明当天购买了股票
        dp[0][1] = 0;

        for(int i=1;i<len;i++){
            /**
             * 当前持有股票
             * 1. 昨天没有股票，今天买了 与LC_121的区别就是这里可以进行多次交易 因此为dp[i-1][1]-prices[i]
             * 2. 昨天持有股票，今天啥事没干
             */
            dp[i][0] = Math.max(dp[i-1][1]-prices[i],dp[i-1][0]);
            /**
             * 当前没有股票
             * 1. 昨天持有股票，今天卖了
             * 2. 昨天没有股票，今天啥也没干
             */
            dp[i][1] = Math.max(dp[i-1][0]+prices[i],dp[i-1][1]);
        }

        /**
         * 最后一天持有股票必亏
         * 没有股票的收入>=0
         * 因此直接返回dp[len-1][1]
         */
        return dp[len-1][1];
    }

    public int maxProfit2(int[] prices) {
        /**
         * dp[0]表示第i天持有股票所得最多现金
         * dp[1]表示第i天没有股票所得最多现金
         */
        int len = prices.length;
        //dp[i]只与dp[i-1]相关 因此将二维数组的size设为dp[2][2]
        int dp[][] = new int[2][2];

        dp[0][0] -= prices[0];//说明当天购买了股票
        dp[0][1] = 0;

        for(int i=1;i<len;i++){
            /**
             * 当前持有股票
             * 1. 昨天没有股票，今天买了
             * 2. 昨天持有股票，今天啥事没干
             */
            dp[i%2][0] = Math.max(dp[(i-1)%2][1]-prices[i],dp[(i-1)%2][0]);
            /**
             * 当前没有股票
             * 1. 昨天持有股票，今天卖了
             * 2. 昨天没有股票，今天啥也没干
             */
            dp[i%2][1] = Math.max(dp[(i-1)%2][0]+prices[i],dp[(i-1)%2][1]);
        }

        return dp[(len-1)%2][1];
    }
}
