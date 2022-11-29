package Competition;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 91Week双周赛
 * 不同的平均值数目 P1
 */
public class LC_2465 {
    public static int distinctAverages(int[] nums) {
        Set<Double> average = new HashSet<>();
        Arrays.sort(nums);
        List<Integer> list = new LinkedList<>();
        for(int i=0;i<nums.length;i++)
            list.add(nums[i]);
        while(list.size()>0){
            //记得转double哦
            double avg = (double) (list.get(0) + list.get(list.size()-1))/2;
            average.add(avg);
            list.remove(0);
            list.remove(list.size()-1);
        }
        return average.size();
    }


    public static int distinctAverages2(int[] nums) {
        Set<Double> average = new HashSet<>();
        Arrays.sort(nums);
//        List<Integer> list = new LinkedList<>();
//        for(int i=0;i<nums.length;i++)
//            list.add(nums[i]);
        //不需要借助list 使用双指针 一个指向nums的头 一个指向nums的尾 因为nums已经排好序了
        int left = 0, right = nums.length-1;
        while(left<right){
            //记得转double哦
            double avg = (double) (nums[left] + nums[right])/2;
            average.add(avg);
            left++;
            right--;
        }
        return average.size();
    }

    public static void main(String[] args) {
        int nums[] = {4,1,4,0,3,5};
        distinctAverages(nums);
    }
}
