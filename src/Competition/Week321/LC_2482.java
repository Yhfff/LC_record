package Competition.Week321;

/**
 * 92周双周赛 Problem2
 */
public class LC_2482 {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans[][] = new int[m][n];
        //统计每一行1的数目
        int cntRow1[] = new int[m];
        //统计每一列1的数目
        int cntCol1[] = new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    cntRow1[i]++;
                    cntCol1[j]++;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
               ans[i][j] = cntRow1[i] + cntCol1[j] - (n-cntRow1[i]) - (m-cntCol1[j]);
            }
        }
        return ans;
    }
}
