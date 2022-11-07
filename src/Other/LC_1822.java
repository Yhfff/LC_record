package Other;

/**
 * 10.27每日一题
 * 数组元素积的符号
 */
public class LC_1822 {
    public static void main(String[] args) {
        int a[] = {41,65,14,80,20,10,55,58,24,56,28,86,96,10,3,84,4,41,13,32,42,43,83,78,82,70,15,-41};
        System.out.println(a.length);
        int res = 1;
        for(int i=0;i<a.length;i++)
            res *= a[i];
        System.out.println(res);
    }

    /**
     * 1 <= nums.length <= 1000
     * -100 <= nums[i] <= 100
     */

    public int arraySign(int[] nums) {
        int cntNeg = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0)
                cntNeg += 1;
            if(nums[i]==0) return 0;
        }
        return (cntNeg%2==0)?1:-1;
    }

    //直接遍历相乘 溢出空间 int32位
    //可使用BigInteger
    public int arraySign2(int[] nums) {
        int res = 1;
        for(int i=0;i<nums.length;i++)
            res *= nums[i];
        if(res>0) return 1;
        else if(res==0) return 0;
        else return -1;
    }
}
