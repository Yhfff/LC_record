package DP.Stock;


/**
 * 买卖股票的最佳时机
 */
public class LC_121 {
    //选择一天买入 再选择一天卖出 只有一笔交易 问最大收益
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
             * 1. 昨天没有股票，今天买了 -price[i](因为只能买一次)
             * 2. 昨天持有股票，今天啥事没干
             */
            dp[i][0] = Math.max(-prices[i],dp[i-1][0]);
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

    //dp[i]只跟dp[i-1]有关 利用滚动数组优化
}
