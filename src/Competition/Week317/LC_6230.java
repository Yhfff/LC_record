package Competition.Week317;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem2
 * 长度为K子数组的最大和
 * 与LC_209比较
 */
public class LC_6230 {
    public static void main(String[] args) {
        int nums[] = {1,5,4,2,9,9,9};
        int k = 3;
       // System.out.println(Arrays.stream(nums).max().getAsInt());
        System.out.println(maximumSubarraySum(nums,k));
    }

    // 滑动窗口 + hashmap 关键点在于判断重复
    public static long maximumSubarraySum(int[] nums, int k) {
        long res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        long sum = 0;

        for(int i=0;i<k;i++){
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        if(map.size()==k)
            res = Math.max(sum,res);

        for(int i=k;i<nums.length;i++){
            sum += nums[i];
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);

            sum -= nums[i-k];
            int cnt = map.get(nums[i-k]);
            if(cnt==1) map.remove(nums[i-k]);
            else map.put(nums[i-k],cnt-1);

            if(map.size()==k)
                res = Math.max(sum,res);
        }
        return res;
    }

//    public static long maximumSubarraySum(int[] nums, int k) {
//        //k==1 直接返回数组最大值
//        if(k==1) return(long) Arrays.stream(nums).max().getAsInt();
//
//        int len = nums.length;
//        //dp[i]表示以第i个数结尾的长度为k的子数组最大和
//        long dp[] = new long[len+1];
//        //先计算dp[k]
//        for(int i=0;i<k;i++){
////            if(i>=1 && nums[i]==nums[i-1])
////                return 0;
//            dp[k] += nums[i];
//        }
//
//
//        //从第k个数开始遍历
//        for(int i=k;i<len;i++){
//            if(nums[i]==nums[i-1])
//                dp[i+1] = 0;
//            else {
//                dp[i+1] = dp[i] + nums[i] - nums[i-k];
//            }
//        }
//
////        System.out.println(dp[5]);
////        for (long x: dp) {
////            System.out.printf("%-3d",x);
////        }
//
//        return Arrays.stream(dp).max().getAsLong();
//    }
}
