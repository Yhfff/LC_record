package Other;

/**
 * 10.28每日一题
 * 子数组的最小值之和
 */
public class LC_907_tag {
    public static void main(String[] args) {
        int a[] = {11,81,94,43,3};
        System.out.println(sumSubarrayMins(a));
    }

    //找每个数作为最小值能有多少个子数组符合条件
    public static final int MOD = 1000000007;
    public static int sumSubarrayMins(int[] arr) {
        int len = arr.length;
        int res = 0;
        for(int i=0;i<len;i++){
            res += arr[i];
            int min = arr[i];
            for(int j=i+1;j<len;j++){
                min = Math.min(min,arr[j]);
                res = (res+min) % MOD;  //每次都要mod一次
            }
        }
        return res;
    }
}
