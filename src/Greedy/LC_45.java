package Greedy;


//跳跃游戏2
public class LC_45 {
    public static int jump(int[] nums)
    {
        int len = nums.length;
        if(len==1) return 0;
        int cur = 0;//当前覆盖最远距离下标
        int res = 0;//返回答案
        int next = 0;//下一步覆盖最远距离下标

        for(int i=0;i<len;i++)
        {
            next = Math.max(nums[i]+i,next); //更新下一步覆盖最远距离下标
            if(i==cur)  //遇到当前覆盖最远距离的下标
            {
                if(cur!=len-1){ //最远距离不是终点
                    res++;  //需要走一步
                    cur = next; //更新当前覆盖最远距离
                    if(next>=len-1) break; //如果下一步的范围已经可以到达终点 直接break
                }else break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int nums[] = {2,3,1,1,4};

        System.out.println(jump(nums));
    }
}
