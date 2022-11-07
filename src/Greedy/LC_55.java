package Greedy;

//跳跃游戏
public class LC_55
{
    //贪心：每次取最大范围
    public static boolean canJump(int[] nums)
    {
        int len = nums.length;
        int cover = 0; //覆盖范围
        for(int i=0;i<=cover;i++)
        {
            cover = Math.max(cover,i+nums[i]); //更新覆盖范围
            if(cover>=len-1) return true;  //如果覆盖范围达到了len-1 则说明可达
        }
        return false;
    }


//    public static boolean canJump(int[] nums)
//    {
//        int len = nums.length;
//        if(len==1) return true;
//
//        boolean canArrive[] = new boolean[len];
//        for(int i=0;i<len;i++)
//        {
//            for(int j=i;j<=i+nums[i];j++) //i+nums[i]可能会越界 可达写得有问题
//            {
//                if(j<len)
//                    canArrive[j] = true;
//                else break;
//            }
//            if(canArrive[i]==true && (i+nums[i])>=len-1)
//                return true;
//        }
//        return false;
//    }

    public static void main(String[] args)
    {
        int nums[] = {3,2,1,0,4};
        System.out.println(canJump(nums));
    }
}
