import java.util.Arrays;

//最后一块石头的重量2
public class LC_1049 {
    public static void main(String[] args) {
        System.out.println(11/2);
    }

    /**
     * 尽量让石头分成重量相同的两堆，相撞之后剩下的石头最小，这样就化解成01背包问题了
     */
    public static int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();  //使用流求数组的和
        //dp[j]表示 背包总容量是j，最大可以背的石头重量  最大为一半
        int target = sum/2;
        int dp[] = new int[target + 1];
        //开始01背包
        //遍历石头
        for(int i=0;i<stones.length;i++){
            //遍历容量
            for(int j=target;j>=stones[i];j--)
                dp[j] = Math.max(dp[j],dp[j-stones[i]]+stones[i]);
        }
        return sum - dp[target] - dp[target];
    }
}
