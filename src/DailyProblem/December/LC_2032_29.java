package DailyProblem.December;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 12.29 每日一题
 * 至少在两个数组中出现的值
 */
public class LC_2032_29 {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> ans = new ArrayList<>();
        int nums[] = new int[101];
        boolean flag[] = new boolean[101];
        for(int num : nums1){
            if(!flag[num]){
                nums[num]++;
                flag[num] = true;
            }
        }
        Arrays.fill(flag, false);
        for(int num : nums2){
            if(!flag[num]){
                nums[num]++;
                flag[num] = true;
            }
        }
        Arrays.fill(flag, false);
        for(int num : nums3){
            if(!flag[num]){
                nums[num]++;
                flag[num] = true;
            }
        }
       for(int i = 1;i <= 100;i++){
           if(nums[i] >= 2)
               ans.add(i);
       }
        return ans;
    }
}
