package Other;

import java.util.Arrays;

/**
 * 11.14 每日一题
 * 数组的均值分割
 */
public class LC_805 {
    /**
     * 未解决
     */
    public static boolean splitArraySameAverage(int[] nums) {
        int len = nums.length;
        if(len==1) return false;
        int sum = Arrays.stream(nums).sum();
        float avg = (float) sum/len;
        for(int i=1;i<len;i++){
            /**
             * 7.0 7.2
             * avg = 7.2 cnt = 2
             * avg * cnt = 14.2
             */
            boolean success = isSpilt(nums,avg,i);
            if(success) return true;
        }
        return false;
    }

    public static boolean isSpilt(int[] nums,float avg,int cnt) {
        int target = (int)(cnt * avg);
        int dp[] = new int[target + 1];
        //开始01背包
        //遍历物品
        for(int i=0;i<nums.length;i++){
            //遍历容量
            for(int j=target;j>=nums[i];j--)
                dp[j] = Math.max(dp[j],dp[j-nums[i]]+nums[i]);
        }
        return dp[target]==target;
    }


    public static void main(String[] args) {
        int len = 8;
        int sum = 36;
        float avg = (float)sum/len;
        int nums[] = {1,2,3,4,5,6,7,8};
        System.out.println((int)(2.5*1));
        System.out.println(splitArraySameAverage(nums));
    }





}
