package Other;

import java.util.Arrays;

/**
 * 11.18每日一题
 * 子序列宽度之和
 * 困难
 */
public class LC_891 {

    private static final int MOD = (int) (1e9+7);

    public int sumSubseqWidths(int[] nums) {
        long ans = 0;
        int len = nums.length;
        //提前处理幂运算
        long pow[] = new long[len];
        pow[0] = 1;
        for(int i=1;i<len;i++)
            pow[i] = pow[i-1] * 2 % MOD;
        //数组排序
        Arrays.sort(nums);
        for(int i=0;i<len;i++){
            ans += (pow[i] - pow[len-i-1])*nums[i];
        }
        //pow[i] - pow[len-i-1] 可能会有负数
        return (int) ((ans%MOD+MOD) % MOD);
    }

    public static void main(String[] args) {
        //测试long的范围
        long a = (long) Math.pow(2,1000);
        System.out.println(a);
    }
}
