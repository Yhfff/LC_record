package DailyProblem;

/**
 * 11.20每日一题
 * 香槟塔
 * 动态规划
 */
public class LC_799 {
    public double champagneTower(int poured, int query_row, int query_glass) {
        /**
         * dp[i][j] 表示某个杯子
         * 每一个香槟杯的香槟只会来自于dp[i-1][j]  dp[i-1][j-1]
         */
        double dp[][] = new double[query_row+2][query_row+2];
        //先把所有香槟全部导入最上层杯子
        dp[1][1] = poured; //防止越界
        for(int i=2;i<=query_row+1;i++){
            for(int j=1;j<=i;j++){
                //上一层的杯子得溢出来才会流到下一层
                dp[i][j] = Math.max(dp[i-1][j]-1,0)/2 + Math.max(dp[i-1][j-1]-1,0)/2;
            }
        }
        //最上面一层 防止返回poured
        return Math.min(dp[query_row+1][query_glass+1],1);
    }
}
