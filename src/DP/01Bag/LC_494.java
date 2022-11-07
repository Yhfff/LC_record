import java.util.Arrays;
import java.util.stream.Stream;

//目标和
public class LC_494 {
    public int res = 0;

    public static void main(String[] args) {
        int nums[] = {0,0,0,1};
        int target = 1;
        System.out.println(findTargetSumWays1(nums,target));
    }

    /**
     * left - right = target
     * left + right = sum
     * ——》》 left = (target+sum)/2
     * 问题转化成在数组 nums中选取若干元素，使得这些元素之和等于 left，计算选取元素的方案数
     * dp
     * dp[i][j]表示从前i个数里 凑成和为j的方案数
     * return dp[len][left]
     */
    public int findTargetSumWays(int[] nums, int target) {
        int len = nums.length;
        int sum = Arrays.stream(nums).sum(); //流的方法求和

        /**
         * 1. 如果target的绝对值比sum都要大 肯定不可能 比如target=7 sum=6
         * 2. 如果sum+target不能整除2 也不可能 比如sum=7 target=4
         *    因为2*left = sum+target 一定为偶数
         */
        if(Math.abs(target)>sum || (sum+target)%2!=0)
            return 0;

        int pos = (sum+target)/2;

        /**
         * dp[i][j]表示从前i个数里 凑成和为j的方案数
         * dp[0][0] = 1 啥也不放也是一种方案
         * dp[0][j] = 0(j>=1)
         * dp[i][j] =
         */
        int dp[][] = new int[len+1][pos+1];
        dp[0][0] = 1;
        //遍历数字
        for(int i=1;i<=len;i++){
            //遍历和
            for(int j=0;j<=pos;j++){ //pos要从0开始 nums[i]会存在=0的情况  dp[1][0]不一定为1
                /**
                 * j能够装下nums[i] 即j>=nums[i]
                 * 这里求的是方案数
                 * dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i]];
                 */
                if(j>=nums[i-1]){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                }else
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[len][pos];
    }

    //滚动数组
    public static int findTargetSumWays1(int[] nums, int target) {
        int len = nums.length;
        int sum = Arrays.stream(nums).sum();
        if(Math.abs(target)>sum || (sum+target)%2!=0)
            return 0;
        int pos = (sum+target)/2;

        /**
         * dp[i]表示凑成和为i的方案数
         */
        int dp[] = new int[pos+1];
        /**
         * 疑问：如果存在i 使nums[i]=0 那么dp[0]!=1 =2
         */
        dp[0] = 1; //默认的啥也不放 会有一种
        //遍历数字
        for(int i=0;i<len;i++){
            //遍历和
            for(int j=pos;j>=nums[i];j--){
                 dp[j] += dp[j-nums[i]]; //若存在nums[i]=0 dp[0] += dp[0] 就是把nums[i]=0往里面放
            }
        }

        return dp[pos];
    }


    //回溯  dfs?
    public int findTargetSumWays2(int[] nums, int target) {
        backtrack(nums,target,0,0);
        return res;
    }

    public void backtrack(int []nums,int target,int index,int sum){
        if(sum==target) //不仅要和为target 长度也要为nums.length 保证每个数均被使用
        {
            if(index== nums.length){
                res++;
                return;
            }
        }
        backtrack(nums,target,index+1,sum+nums[index]);
        backtrack(nums,target,index+1,sum-nums[index]);
    }

}
