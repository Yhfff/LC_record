package DailyProblem;

/**
 * 11.21 每日一题
 * 分汤
 */
public class LC_808 {
    //暴力搜索4叉树(dfs) 会超时
    int [][]soup = {{100,0},{75,25},{50,50},{25,75}};
    public double soupServings(int n) {
        return dfs(n,n);
    }

    public double dfs(int a,int b){
        if(a<=0){
            if(b<=0) return 0.5; //A与B同时分配完
            return 1; //A先分配完
        }

        if(b<=0) return 0; //B先分配完

        double ans = 0;
        for(int i=0;i<4;i++){
            ans += 0.25*dfs(a-soup[i][0],b-soup[i][1]);
        }

        return ans;
    }

    /**
     * 仔细分析一波 操作2和4是对称的 然后3是均等分配 而1是A100 B0
     * 其实 -》 A率先分完的概率肯定是比B要大的
     * 在n非常大的时候，汤A会有很大的概率比 B先分配完，汤A被先取完的概率应该非常接近1 即最后的结果就是1
     */


    /**
     * 动态规划
     * 25ml为一份
     * dp(i,j)表示汤 A和汤 B分别剩下 i 和 j 份时所求的概率值
     */
    public double soupServings2(int n) {
        //double要加
        n = (int)Math.ceil((double)n/25);
        //敢于特判  概率论 数学期望
        if(n>=179)
            return 1;
        double dp[][] = new double[n+1][n+1];
        dp[0][0] = 0.5;
        for(int j=1;j<=n;j++)
            dp[0][j] = 1;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++)
            {
                //尽可能分配
                dp[i][j] = 0.25*(dp[Math.max(i-4,0)][j] + dp[Math.max(i-3,0)][j-1] +
                        dp[Math.max(i-2,0)][Math.max(j-2,0)] + dp[i-1][Math.max(j-3,0)]);
            }
        }
        return dp[n][n];//返回的是一开始的概率
    }



    public static void main(String[] args) {
        int n = 1;
        n = (int)Math.ceil((double)n/25);
        System.out.println(n);
    }




}
