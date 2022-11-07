package TwoPointer;
//长度最小的子数组
//与LC_6230比较
public class LC_209
{
    //滑动窗口 双指针
    public static int minSubArrayLen(int target, int[] nums)
    {
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for(int right=0;right<nums.length;right++)
        {
            sum += nums[right];
            while (sum>=target && left<nums.length)
            {
                ans = Math.min(ans,right-left+1);
                sum -= nums[left];
                left++;
            }
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }

    //暴力
    public static int minSubArrayLen_2(int target, int[] nums)
    {
        int ans = Integer.MAX_VALUE;
        int len = nums.length;
        for(int i=0;i<len;i++)
        {
            //int newTarget = target-nums[i];
            int temp = 0;
           // if(newTarget<=0) return 1;
            for(int j=i;j<len;j++)
            {
                temp += nums[j];
                if(temp>=target)
                {
                    ans = Math.min(ans,j-i+1);
                    break;
                }
            }
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }

    public static void main(String[] args)
    {
        int target = 7;
        int nums[] = {2,3,1,2,4,3};
        int ans = minSubArrayLen(target,nums);
        System.out.println(ans);
    }
}
