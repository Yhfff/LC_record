package Competition.Week327;

import java.util.Arrays;

/**
 * Week327 周赛
 * 正整数和负整数的最大计数
 */
public class LC_2529 {
    // 二分查找
    public int maximumCount(int[] nums) {
        int len = nums.length;
        int left = 0, right = len - 1;
        // 第一个大于等于0的元素的下标
        int index1 = binarySearch(left, right, nums, 0);
        // 第一个大于等于1的元素的下标
        int index2 = binarySearch(left, right, nums, 1);
        return Math.max(index1, len - index2);
    }
    // 二分查找第一个>=target元素的下标
    public int binarySearch(int left, int right, int[] nums, int target){
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] == target){
                // 不可以立即返回 因为要找最左边的
                right = mid - 1;
            }else {
                right = mid - 1;
            }
        }
        // target大于nums所有元素
        if(left == nums.length) return nums.length;
        return left;
    }


    // 遍历
    public int maximumCount2(int[] nums) {
        int pos = 0,neg = 0;
        for(int num: nums){
            if(num > 0) pos++;
            else if(num == 0) continue;
            else neg++;
        }
        return Math.max(pos, neg);
    }
}
