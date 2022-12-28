package CodeTop;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 11.23
 * 数组中的第K个最大元素
 * CodeTop4
 */
public class LC_215_4 {

    /**  快排
     * 第K大 -》 堆
     */
    public int findKthLargest(int[] nums, int k) {
        // 建立一个大小为k的小根堆 最后的堆顶就是第k大的元素
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num : nums){
            if(minHeap.size() < k || num > minHeap.peek())
                minHeap.add(num);
            if(minHeap.size() > k)
                minHeap.poll();
        }
        return minHeap.peek();
    }


    public int findKthLargest3(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
