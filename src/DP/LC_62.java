package DP;

//不同路径
public class LC_62 {
    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        System.out.println(uniquePaths(m,n));
    }


    /**
     * 滚动数组 二维-》一维？
     */
    public static int uniquePaths(int m, int n) {
        int dp[][] = new int[m+1][n+1];  //dp[i][j]表示从起点到（i,j）位置的路径

        dp[1][0] = 1;
//        for(int i=2;i<=m;i++)
//            dp[i][1] = dp[i-1][1];   //只能往下走
//        for(int j=2;j<=n;j++)
//            dp[1][j] = dp[1][j-1];           //只能往右走
        for(int i=1;i<=m;i++)
            for(int j=1;j<=n;j++)
                dp[i][j] = dp[i-1][j] + dp[i][j-1]; //从上来的 + 从左来的


        for(int i=0;i<=m;i++)
        {
            for(int j=0;j<=n;j++)
                System.out.printf("%-3d",dp[i][j]);
            System.out.println();
        }
        return dp[m][n];
    }

    //dfs 深搜 但是会超时
    //dfs(1,1,m,n)
    public int dfs(int i,int j,int m,int n)
    {
        if(i>m || j>n) return 0;//越界 返回0
        if(i==m && j==n) return 1;//找到一条路径
        return dfs(i+1,j,m,n) + dfs(i,j+1,m,n);
    }

}
