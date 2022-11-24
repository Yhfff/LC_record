package DP.subSequence;

/**
 *  不同的子序列
 */
public class LC_115 {
    public int numDistinct(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        //dp[i][j]: 以i-1为结尾的s子序列中出现以j-1为结尾的t的个数为dp[i][j]
        int dp[][] = new int[lenS+1][lenT+1];
        //初始化
        for(int i=0;i<=lenS;i++)
            dp[i][0] = 1;
        for(int i=1;i<=lenS;i++){
            for(int j=1;j<=lenT;j++){
                if(s.charAt(i-1)==t.charAt(j-1))
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[lenS][lenT];
    }
}
