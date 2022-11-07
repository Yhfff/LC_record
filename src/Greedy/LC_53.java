package Greedy;

//最大子数组和
public class LC_53
{
    public static void main(String[] args) {
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }


    /**
     * 贪心
     * 当前连续和为负数的时候直接放弃，从下一个元素重新开始计算，因为负数一定会拉低连续和，使连续和越来越小
     */
    public static int maxSubArray(int[] nums)
    {
        int res = Integer.MIN_VALUE;
        int flag = 0;
        for(int i=0;i<nums.length;i++)
        {
            flag += nums[i];
            if(flag>res) res=flag;
            if(flag<0) flag=0;
        }
        return res;
    }
}
