package DailyProblem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 11.9 每日一题
 * 最大加号标志
 */
public class LC_764 {
    public static void main(String[] args) {
        int n = 5;
        int [][]mines = {{4,2}};
        System.out.println(orderOfLargestPlusSign(n,mines));
    }

    //官方题解
    public static int orderOfLargestPlusSign(int n, int[][] mines) {
        /**
         *  dp[i][j][k] 表示以 (i,j)为起点在方向k上的连续1的最大数目
         *  dp[i][j] 保存四个方向中最小的连续1的个数即可
         */
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], n); //dp[i][j]初始值设为n
        }

        Set<Integer> banned = new HashSet<Integer>();
        for (int[] vec : mines) {
            banned.add(vec[0] * n + vec[1]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            /* left */
            for (int j = 0; j < n; j++) {  //从左往右遍历
                if (banned.contains(i * n + j)) {
                    count = 0;
                } else {
                    count++;
                }
                dp[i][j] = Math.min(dp[i][j], count);
                // dp[0][1] -> dp[0][2] -> dp[0][3] -> ..... dp[0][j]
            }

            count = 0;
            /* right */
            for (int j = n - 1; j >= 0; j--) {  //从右往左遍历
                if (banned.contains(i * n + j)) {
                    count = 0;
                } else {
                    count++;
                }
                dp[i][j] = Math.min(dp[i][j], count);
                // dp[0][n-1] -> dp[0][n-2] -> dp[0][n-3] -> ..... dp[0][j]
            }
        }


        for (int i = 0; i < n; i++) {
            int count = 0;
            /* up */
            for (int j = 0; j < n; j++) {  //从上往下遍历
                if (banned.contains(j * n + i)) {
                    count = 0;
                } else {
                    count++;
                }
                dp[j][i] = Math.min(dp[j][i], count); //dp[j][i]
                // dp[0][0] -> dp[1][0] -> dp[2][0] -> ..... dp[j][0]
            }
            count = 0;
            /* down */
            for (int j = n - 1; j >= 0; j--) {  //从下往上遍历
                if (banned.contains(j * n + i)) {
                    count = 0;
                } else {
                    count++;
                }
                dp[j][i] = Math.min(dp[j][i], count);
                ans = Math.max(ans, dp[j][i]);
            }
        }

        return ans;
    }

    //暴力
    public static int orderOfLargestPlusSign2(int n, int[][] mines) {
        int grid[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(grid[i],1); //Arrays.fill只能填充一维数组
        }

        for(int i=0;i<mines.length;i++)
            grid[mines[i][0]][mines[i][1]] = 0;

        int res = 0;
        int cnt;
        for(int i = 0;i<n;i++){
            for(int j=0;j<n;j++){
                cnt = 0;
                if(grid[i][j]==1){
                    cnt = 1;
                    int step = Math.min(i,j); //每一个起点能最大往外延伸的长度
                    for(int k=1;k<=step;k++){
                        if(i-k<0 || i+k>=n || j-k<0 || j+k>=n)
                            break;
                        if(grid[i-k][j] == 1 && grid[i+k][j] == 1
                          && grid[i][j-k] == 1 && grid[i][j+k] == 1)
                        {
                            cnt++;
                        }else {
                            break;  //需要加break 一旦不满足 表明这个点已经结束
                        }
                    }
                }
                res = Math.max(res,cnt);
            }
        }

        return res;
    }


}
