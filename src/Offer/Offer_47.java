package Offer;


/**
 * Offer_47 礼物的最大价值
 */
public class Offer_47 {
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m+1][n+1];
        for(int i = 1; i <= m;i++){
            for(int j = 1;j <= n;j++){
                dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]) + grid[i-1][j-1];
            }
        }
        return dp[m][n];
    }

    // 直接将grid数组当成dp数组
    public int maxValue2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(i == 0 && j == 0) continue;
                if(i == 0) grid[i][j] += grid[i][j-1];
                else if(j == 0) grid[i][j] += grid[i-1][j];
                else grid[i][j] += Math.max(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];
    }
}
