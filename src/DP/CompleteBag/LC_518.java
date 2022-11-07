package DP.CompleteBag;

//零钱兑换2
//与LC_494比较 递推公式差不多
//与LC_39 其实就是一个组合题 用回溯的话最后返回的结果就是res.size()
public class LC_518 {


    public static void main(String[] args) {
        int amount = 4;
        int coins[] = {1,2,3};
        System.out.println(change(amount,coins));
    }

    /**
     * 一种硬币有无限枚 可以无限放
     */
    public static int change(int amount, int[] coins) {
        int len = coins.length;
        //dp[i]表示凑i元的组合数
        int dp[] = new int[amount+1];
        dp[0] = 1;

        //如果求组合数就是外层for循环遍历物品，内层for遍历背包
        //遍历硬币
        for(int i=0;i<len;i++){
            /**
             *  遍历背包容量 即金额总数amount
             *  完全背包 从头开始遍历 不需要倒序
             */
            for(int j=1;j<=amount;j++){
                if(j>=coins[i])
                    //求装满背包有几种方法，一般公式都是：dp[j] += dp[j - nums[i]]
                    dp[j] += dp[j-coins[i]];
            }
        }

        return dp[amount];


    }
}
