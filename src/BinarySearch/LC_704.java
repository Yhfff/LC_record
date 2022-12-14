package BinarySearch;


/**
 * 二分查找
 */
public class LC_704 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        /**
         * 闭区间[left,right]  循环不变量
         * 终止条件 left = right + 1, 即while(left<=right)
         */
        while (left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target){
                left = mid + 1; //[mid+1,right]  mid已经被搜索过了
            }else
                right = mid - 1; //[left, mid-1]
        }
        return -1;
    }
}
