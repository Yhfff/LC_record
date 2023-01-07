package DailyProblem.January;

import java.util.Arrays;

/**
 * 1.7 每日一题
 * 将x减到0的最小操作数
 */
public class LC_1658_7 {
    /**
     * 逆向思维
     * 将问题转化成 ： 从nums中移除一个最长的子数组b，使得剩余元素的和为 x
     *              移除子数组的和为sum(b) = sum(nums) - x
     * 返回len(nums) - len(b)
     * 双指针：窗口大小不固定
     */
    public int minOperations(int[] nums, int x) {
        int target = Arrays.stream(nums).sum() - x;
        if(target < 0) return -1;
        int ans = -1, left = 0, sum = 0, len = nums.length;
        for(int right = 0;right < len;right++){
            sum += nums[right];
            while(sum > target) sum -= nums[left++];
            if(sum == target) ans = Math.max(ans, right - left + 1);
        }
        return ans == -1 ? -1 : len - ans;
    }
}
