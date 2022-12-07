package DailyProblem.December;

import java.util.Arrays;

/**
 * 12.7 每日一题
 * 通过最少操作次数使数组的和相等
 */
public class LC_1775_7 {
    public int minOperations(int[] nums1, int[] nums2) {
        int sum1 = Arrays.stream(nums1).sum();
        int sum2 = Arrays.stream(nums2).sum();
        if(sum1==sum2) return 0;
        //假定sum1<sum2
        if(sum1 > sum2) return minOperations(nums2, nums1);
        //cnt[i]表示每次变化为i的次数  变化范围为[0,5]
        int cnt[] = new int[6];
        /**
         * 由于假定sum1<sum2
         * nums1中的数需增加
         * nums2中的数需减小
         */
        for(int nums: nums1)
            cnt[6-nums]++;
        for(int nums: nums2)
            cnt[nums-1]--;

        int ans = 0;
        int diff = sum2 - sum1;
        // 由于是最少次数 因此倒序遍历 贪心
        for(int i = 5;i >= 0;i--){
            while(cnt[i] > 0 && diff > 0){
                cnt[i]--;
                diff -= i;
                ans++;
            }
        }
        return diff<=0 ? ans : -1;
    }
}
