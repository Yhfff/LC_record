package Greedy;


/**
 * 最长连续递增序列
 */
public class LC_674 {
    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        int res = 1;
        int count = 1;
        for(int i=1;i<len;i++){
            if(nums[i]>nums[i-1])
                count++;
            else
                count = 1;
            res = Math.max(res,count);
        }
        return res;
    }
}
