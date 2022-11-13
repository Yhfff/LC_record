package Competition.Week319;

/**
 * 最大公因数等于 K 的子数组数目
 * 最大公因数GCD (Greatest Common Divisor)
 * 与Week319周周赛思路雷同
 * LC_6234
 */
public class LC_2447 {
    public int subarrayGCD(int[] nums, int k) {
        int res = 0;
        int len = nums.length;
        for(int i=0;i<len;i++){
            int maxDivisor = nums[i];
            if(maxDivisor==k) res++;
            for (int j=i+1;j<len;j++){
               maxDivisor = gcd(maxDivisor,nums[j]);
               if(maxDivisor==k){
                   res++;
               }
            }
        }
        return res;
    }

    public static int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}
