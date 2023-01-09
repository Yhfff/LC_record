package Competition.Week327;


import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Week327 周赛 P2
 * 执行K次操作后的最大分数
 */
public class LC_2530 {
    // 使用最大堆 优先队列
    public long maxKelements(int[] nums, int k) {
        long ans = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((o1, o2) -> (o2 - o1)));
        for(int num : nums){
            maxHeap.add(num);
        }
        while(k > 0){
            int tmp = maxHeap.poll();
            ans += tmp;
            maxHeap.add((int) Math.ceil((double) tmp / 3));
            k--;
        }
        return ans;
    }


    // 暴力 会超时
    public long maxKelements2(int[] nums, int k) {
        long ans = 0;
        int len = nums.length;
        while(k > 0){
            Arrays.sort(nums);
            ans += nums[len - 1];
            nums[len - 1] = (int) Math.ceil((double) nums[len - 1] / 3);
            k--;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println( Math.ceil((double) 19 / 3));
    }
}
