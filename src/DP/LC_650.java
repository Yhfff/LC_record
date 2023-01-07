package DP;

/**
 * 只有两个键的键盘
 */
public class LC_650 {
    public int minSteps(int n) {
        int dp[] = new int[1001];
        dp[1] = 0;
        dp[2] = 2;
        // 如果n是质数 则dp[n] = n
        for(int i = 3;i <= n;i++){
            dp[i] = i;
            for(int j = 2;j < i;j++){
                if(i % j == 0)
                    // 找因数
                    dp[i] = Math.min(dp[i], dp[j] + i/j);
            }
        }
        return dp[n];
    }

    public static int minSteps2(int n) {
        int dp[] = new int[1001];
        dp[1] = 0;
        dp[2] = 2;
        // 如果n是质数 则dp[n] = n
        for(int i = 3;i <= n;i++){
            dp[i] = i;
            for(int j = 2;j <= (int)Math.sqrt(i);j++){
                if(i % j == 0){
                    // 找因数
                    dp[i] = Math.min(dp[i], dp[j] + i/j);
                    dp[i] = Math.min(dp[i], dp[i/j] + j);
                }
            }
      //      System.out.println(dp[i]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(minSteps2(n));
        System.out.println((int)Math.sqrt(5));
    }
}
