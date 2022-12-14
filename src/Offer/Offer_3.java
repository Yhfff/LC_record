package Offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指offer_3
 * 数组中重复的数字
 */
public class Offer_3 {
    public int findRepeatNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            if(map.containsKey(nums[i])) return nums[i];
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
            //if(map.get(nums[i]) > 1) return nums[i];
        }
        return -1;
    }
}
