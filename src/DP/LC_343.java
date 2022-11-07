package DP;

//整数拆分
public class LC_343 {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(integerBreak(n));
    }

    public static int integerBreak(int n) {
        int dp[] = new int[n+1];  //dp[i]表示当将i拆分得到的最大乘积
//        dp[0] = 0;
//        dp[1] = 0; //dp[1]=0 因为0 1无法拆成两个数 所以其实初始化没有意义
        dp[2] = 1;   //初始化dp[2]=1
        for(int i=3;i<=n;i++)
        {
            /**
             * 有两种渠道得到dp[i]
             * 1.j*(i-j)  (将i拆分成两个数)
             * 2.j*dp[i-j](将i拆成两个及两个以上)
             */
            for(int j=1;j<i;j++)
                dp[i] = Math.max(dp[i],Math.max(j*(i-j),j*dp[i-j]));
        }

        return dp[n];
    }
}
