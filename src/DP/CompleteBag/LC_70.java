package DP.CompleteBag;

//爬楼梯
public class LC_70 {

    //求的是排列
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1;

        //如果求排列数就是外层for循环遍历背包，内层for遍历物体
        for(int i=1;i<=n;i++){
           for(int j=1;j<=2;j++){
               if(i>=j)
                   dp[i] += dp[i-j];
           }
        }

        return dp[n];
    }
}
