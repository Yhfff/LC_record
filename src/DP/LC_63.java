package DP;

// 不同路径2
public class LC_63
{
    public static void main(String[] args) {

    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[][] = new int[m+1][n+1];  //dp[i][j]表示从起点到（i,j）位置的路径

        dp[1][0] = 1;

//        for(int i=2;i<=m;i++)
//            dp[i][1] = dp[i-1][1];   //只能往下走
//        for(int j=2;j<=n;j++)
//            dp[1][j] = dp[1][j-1];           //只能往右走
        for(int i=1;i<=m;i++)
            for(int j=1;j<=n;j++){
                if(obstacleGrid[i-1][j-1]==1)  //遇到障碍直接将dp[i][j]设置为0 表示此路不通
                    dp[i][j] = 0;
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1]; //从上来的 + 从左来的
            }


        return dp[m][n];
    }


}
