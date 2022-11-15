package Greedy;

/**
 * 买卖股票的最佳时机I
 * 贪心版
 */
public class LC_121 {
    public int maxProfit(int[] prices) {
        //min维护左边的最小值
        int min = Integer.MAX_VALUE;
        int len = prices.length;
        int res = 0;

        for(int i=0;i<len;i++){
            min = Math.min(min,prices[i]);
            res = Math.max(res,prices[i]-min);
        }

        return res;
    }
}
