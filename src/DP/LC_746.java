package DP;

//使用最小花费爬楼梯
public class LC_746 {
    public static void main(String[] args) {
        int cost[] = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCostClimbingStairs(cost));
    }

    /**
     *认为第一节楼梯是不花费的 但最后一节是要花费的
     */
    public static int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int dp[] = new int[len+1]; //dp[i]表示到达i级楼梯的最低花费
        dp[0] = 0;
        dp[1] = 0;
        for(int i=2;i<=len;i++)
            dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        return dp[len];
    }

    /**
     * 认为第一节楼梯花费 最后一节不花费
     */
    public static int minCostClimbingStairs2(int[] cost) {
        int len = cost.length;
        int dp[] = new int[len]; //dp[i]表示到达i级楼梯的最低花费
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i=2;i<len;i++)
            dp[i] = Math.min(dp[i-1],dp[i-2]) + cost[i];
        return Math.min(dp[len-1],dp[len-2]);
    }
}
