package DP.CompleteBag;

import java.util.Arrays;

/**
 * 零钱兑换
 * 与518 零钱兑换II
 */
public class LC_322 {
    public static void main(String[] args) {
        System.out.println(1==1?1:2);
    }
    public int coinChange(int[] coins, int amount) {
        // if(amount==0) return 0;
        /**
         * dp[i]表示凑i元最少需要硬币数
         */
        int dp[] = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;

        //遍历物品
        for(int i=0;i<coins.length;i++){
            for(int j=1;j<=amount;j++){
                // 保证j-coins[i]是可以凑到的 即其不能等于Integer.MAX_VALUE
                if(j>=coins[i] && dp[j-coins[i]] != Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
                }
            }
        }

        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
}
