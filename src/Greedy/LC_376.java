package Greedy;

//摆动序列
public class LC_376
{
    public static void main(String[] args)
    {
       // int[] nums = {1,17,5,10,13,15,10,5,16,8};
        int[] nums = {0,0};
        System.out.println(wiggleMaxLength_dp(nums));
    }

    public static int wiggleMaxLength(int[] nums)
    {
        int res = 1; //答案初始设置为1 默认最右边有一个
        /*
        需要逐差判断 因此preDiff初始为0 如[2,5] 可以认为是【2,2,5】
         */
        int preDiff = 0;
        int curDiff = 0;

        //贪心大多都是遍历数组？
        for(int i=0;i<nums.length-1;i++)
        {
            curDiff = nums[i+1] - nums[i];
            if((curDiff>0 && preDiff<=0) || (curDiff<0 && preDiff>=0))
            {
                res++;
                preDiff = curDiff;
            }
        }
        return res;
    }

    //动态规划 DP
    public static int wiggleMaxLength_dp(int[] nums)
    {
        int len = nums.length;
        /*
        dp[i][0]: 以i结尾的 且第i个元素为山峰的最长长度
        dp[i][1]: 以i结尾的 且第i个元素为山谷的最长长度
         */
        int dp[][] = new int[len][2];
        //dp[0][0] = dp[0][1] = 1;
        for(int i=0;i<len;i++)
        {
            dp[i][0] = dp[i][1] = 1;
            for(int j=0;j<i;j++)
            {
                if(nums[i]>nums[j])
                    dp[i][0] = Math.max(dp[i][0],dp[j][1]+1);

                if(nums[i]<nums[j])
                    dp[i][1] = Math.max(dp[i][1],dp[j][0]+1);
            }
        }
        return Math.max(dp[len-1][0],dp[len-1][1]);
    }
}
