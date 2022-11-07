package DP.CompleteBag;

//组合总和IV
//与LC_518比较
public class LC_377 {

    public int combinationSum4(int[] nums, int target) {
        int len = nums.length;
        int dp[] = new int[target+1];
        dp[0] = 1;

        //如果求排列数就是外层for循环遍历背包，内层for遍历物体
       for(int i=1;i<=target;i++){
           for(int j=0;j<len;j++){
               if(i>=nums[j])
                   dp[i] += dp[i-nums[j]];
           }
       }

        return dp[target];
    }
}
