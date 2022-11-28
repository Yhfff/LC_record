package DailyProblem;

import java.util.HashSet;
import java.util.Set;

/**
 * 11.27 每日一题
 * 检查数组是否经排序和轮转得到
 */
public class LC_1752 {
    public boolean check(int[] nums) {
        int len = nums.length;
        if(len==1) return true;
        /**
         * 不满足的情况很多 因此从满足的情况考虑
         * 统计递减的次数
         * 1. 有两次及以上的递减直接false
         * 2. 0次递减 return true
         * 3. 1次递减 判断nums[0]与nums[len-1]的关系 nums[0]需要大于等于nums[len-1]
         */
        int cnt = 0;
        for(int i=1;i<len;i++){
            if(nums[i]<nums[i-1])
                cnt++;
        }
        if(cnt==0) return true;
        else if(cnt>=2) return false;
        return nums[0]>=nums[len-1];
    }
}
