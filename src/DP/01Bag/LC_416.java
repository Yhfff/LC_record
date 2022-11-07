//分割等和子集

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1. 先使用回溯把所有集合爆搜出来
 * 2. 动态规划
 */
public class LC_416 {

    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        int nums[] = {1,11,5,5};
        System.out.println(canPartition(nums));
    }


    //动态规划  -》 转化成背包问题   -》01背包

    /**
     * 背包的体积：sum/2
     * 物体的重量：nums[i]  物体的价值也是nums[i]
     * 每个物体只能放一次：每个元素只能放一次
     */
    public static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();  //使用流求数组的和
        if(sum%2!=0) return false;//sum为奇数肯定不能等分 即return false
        //dp[j]表示 背包总容量是j，最大可以凑成j的子集总和
        int target = sum/2;
        int dp[] = new int[target + 1];
        //开始01背包
        //遍历物品
        for(int i=0;i<nums.length;i++){
            //遍历容量
            for(int j=target;j>=nums[i];j--)
                dp[j] = Math.max(dp[j],dp[j-nums[i]]+nums[i]);
        }
        return dp[target]==target;
    }




    /**
     *回溯
     *如果一个子集的和为总和的一半 即表示可以分割等和子集
     */
    public static boolean canPartition2(int[] nums) {
        int sum = Arrays.stream(nums).sum();  //使用流求数组的和
        if(sum%2!=0) return false;//sum为奇数肯定不能等分 即return false
        backtrack(nums,0,sum/2,0);
        return res.size()!=0;
    }


    public static void backtrack(int nums[],int startIndex,int target,int curSum){
        //int curSum = path.stream().mapToInt(Integer::intValue).sum();  //求列表的和
        if(curSum==target)
            res.add(new ArrayList<>(path));

        for(int i=startIndex;i<nums.length;i++){
            curSum = curSum + nums[i];
            path.add(nums[i]);
            backtrack(nums,i+1,target,curSum);
            path.remove(path.size()-1);
            curSum = curSum - nums[i];
        }
    }
}
