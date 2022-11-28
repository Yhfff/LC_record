package DailyProblem;

/**
 * 11.28 每日一题
 * 最大平均值和的分组
 */
public class LC_813 {
    /**
     * 划分份数越多，平均值之和越大 因此肯定分k次结果最大
     * 对于将数组划分成多个 -》 动态规划
     * 序列dp
     */
    public static double largestSumOfAverages(int[] nums, int k) {
        /**
         * dp[i][j]为将前i个元素划分成j份的最大平均和
         * sum[i]为前i个元素之和
         */
        int len = nums.length;
        double dp[][] = new double[len+1][k+1];
        //前缀和优化  因为总是在计算前k个元素的和
        double sum[] = new double[len+1];
        for(int i=1;i<=len;i++){
            sum[i] = sum[i-1] + nums[i-1];
            dp[i][1] = sum[i]/i;
        }
        for(int i=1;i<=len;i++) {
            /**
             * dp[i][j] : dp[2][3] 没有意义 k=3 dp[5][4]也没有意义
             */
            //至少拆两份 因此至少俩
            for (int j = 2; j <= Math.min(i, k); j++) {
                //枚举最后一个子数组的起始位置 [m,i]   之前是m-1个元素 分成j-1份
                for (int m = 2; m <= i; m++)
                    dp[i][j] = Math.max(dp[i][j], dp[m - 1][j - 1] + (sum[i] - sum[m - 1]) / (i - m + 1));
            }
        }
        return dp[len][k];
    }
    //以为是贪心，发现写不出来
//    public static double largestSumOfAverages(int[] nums, int k) {
//        double res = 0;
//        int sum = nums[0];
//        int cnt = 1;
//        for(int i=1;i<nums.length;i++){
//            if(nums[i]>nums[i-1]){
//                if(k>0){
//                    System.out.println(sum/cnt);
//                    res += (double) sum/cnt;
//                    sum = nums[i];
//                    cnt = 1;
//                    k--;
//                }
//            }else {
//                sum += nums[i];
//                cnt++;
//            }
//        }
//        return res + (double) sum/cnt;
//    }

    public static void main(String[] args) {
        int []nums = {1,2,3,4,5,6,7};
        int k = 4;
        System.out.println(largestSumOfAverages(nums,k));
    }
}
