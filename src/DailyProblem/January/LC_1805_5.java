package DailyProblem.January;

/**
 * 1.5 每日一题
 * 统计异或值在范围内的数对有多少
 * 字典树 直接跳过
 */
public class LC_1805_5 {
    public int countPairs(int[] nums, int low, int high) {
        int len = nums.length;
        int ans = 0;
        for(int i = 0;i < len;i++){
            for(int j = i + 1;j < len;j++){
                if((nums[i] ^ nums[j]) >= low && (nums[i] ^ nums[j]) <= high)
                    ans++;
            }
        }
        return ans;
    }

}
