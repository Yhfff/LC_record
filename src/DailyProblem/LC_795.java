package DailyProblem;

import java.util.Arrays;

/**
 * 11.24 每日一题
 * 区间子数组个数
 */
public class LC_795 {

//    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
//        int len = nums.length;
//        int cnt = 0;
//        int pointL = 0;
//        int max = nums[0];
//        for(int pointR = 0;pointR<len;pointR++){
//            max = Math.max(nums[pointR],max);
//            if(max>=left && max<=right)
//            {
//                cnt += pointR - pointL + 1;
//            }else {
//                pointL++;
//                max = nums[pointL];
//            }
//        }
//        return cnt;
//    }

    //动态规划
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int len = nums.length;
        //dp[i]表示满足条件的以nums[i]结尾的子数组数目
        int dp[] = new int[len];
        dp[0] = (nums[0]>=left && nums[0]<=right)?1:0;
        //k用来记录前一个大于等于left的位置
        int k = (nums[0]>=left)?0:-1;

        /**
         * nums[i]有三种可能性[0,left) [left,right] (right,)
         * 1. 肯定能与dp[i-1]满足条件
         * 2. 三种情况：自身构成 + 与dp[i-1]构成 + 之前连续小于left的元素 [5,1,1,1,3] 2 4
         * 3. 肯定不满足条件 dp[i]=0
         */
        for(int i=1;i<len;i++){
            if(nums[i]<left) dp[i] = dp[i-1];
            else if(nums[i]>=left && nums[i]<=right){
                dp[i] = 1 + dp[i-1] + (i-k-1);
            }else {
                dp[i] = 0;
            }
            //更新k
            if(nums[i]>=left)
                k = i;
        }
        return Arrays.stream(dp).sum();
    }
}
