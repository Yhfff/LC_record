package DP.Rober;

/**
 * 打家劫舍2
 * 房屋是一个环
 */
public class LC_213 {
    /**
     * 拆成两个打家劫舍I去做
     * 1. 0,1,...,len-2  //肯定不偷最后一间房
     * 2. 1,2,....len-1  //肯定不偷第一间房
     * 然后比较取最大值
     *
     * 特殊情况：如果只有两间房 其实是可以偷其中一间的
     *
     * 把环状排列房间问题约化为两个单排排列房间子问题
     */
    public static int rob(int[] nums) {
        int len = nums.length;
        if(len==1) return nums[0];

        int res1 = Rob(nums,0,len-2);
        int res2 = Rob(nums,1,len-1);

        return Math.max(res1,res2);

    }

    public static int Rob(int[] nums,int start,int end){
        if(start==end) return nums[start]; //长度为2的特殊情况

        int len = end-start+1;
        int dp[] = new int[len];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start],nums[start+1]);
        for(int i=2;i<len;i++)
            dp[i] = Math.max(dp[i-2]+nums[start+i],dp[i-1]);

        return dp[len-1];
    }
}
