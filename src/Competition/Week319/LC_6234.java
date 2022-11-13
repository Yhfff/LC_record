package Competition.Week319;

/**
 * 最小公倍数为 K 的子数组数目
 * 最小公倍数LCM (Leatest Common Multiple)
 */


public class LC_6234 {
    public static int subarrayLCM(int[] nums, int k) {
        int res = 0;
        int len = nums.length;
        for(int i=0;i<len;i++){
            int lcm = nums[i]/gcd(1,nums[i]);
            /**
             * 如果把这句话写外面，那么lcm=k的时候就不会进入二层循环了
             * 可能会漏掉情况
             */
           // if(lcm==k) res++;
            if(lcm<=k){ //如果当前数小于k
                if(lcm==k) res++; //如果当前最小公倍数为k,res++
                for (int j=i+1;j<len;j++){
                    lcm = lcm*nums[j]/gcd(lcm,nums[j]);
                    if(lcm<k) continue;
                    else if(lcm==k) res++;
                    else break;//lcm>k
                }
            }
            //大于k 不用考虑
        }

        return res;
    }

    /**
     * 计算两个数的最小公倍数lcm
     * 结果为乘积/两个数的最大公约数
     * lcm = ab/gcd(a,b)
     */
    public static int lcm(int a,int b){
        return a*b/gcd(a,b);
    }


    public static int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }


    public static void main(String[] args) {
        int []nums = {3};
        int k = 2;
        System.out.println(subarrayLCM(nums,k));
    }
}
