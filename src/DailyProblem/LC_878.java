package DailyProblem;

import java.util.*;

/**
 * 11.22 每日一题
 * 第N个神奇数字
 */
public class LC_878 {
    private static final int MOD = 1000000007;

    /**
     * 二分+容斥
     * 第n个神奇数字是x -》 <=x的神奇数字有n个
     * 找出一个最小的x 满足....>=n
     */
    public int nthMagicalNumber(int n, int a, int b){
        long left = 2;
        //需要加上long 否则过大会溢出
        long right = (long) Math.max(a,b)*n; //[2,(a,b)*n]
        while(left<right){
            long mid = left + (right - left)/2;
            if((mid/a + mid/b - mid/lcm(a,b)) < n){
                left = mid+1;//[mid+1,right]
            }else {
                right = mid;//[left,mid]
            }
        }
        return (int) (left%MOD);
    }

    //最小公倍数
    public int lcm(int a,int b){
        return a*b/gcd(a,b);
    }

    //最大公约数
    public static int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }


    /**
     * 超时
     * HashSet是无序的
     * TreeSet是有序的
     */
    public static int nthMagicalNumber2(int n, int a, int b) {
        Set<Long> set = new TreeSet<>();
        for(int i=1;i<=n;i++){
            set.add((long) ((a*i)%MOD));
            set.add((long) ((b*i)%MOD));
        }
        long nums[] = new long[set.size()];
        int i=0;
        for(long x:set)
            nums[i++] = x;
       // Arrays.sort(nums);
//        for(int y:nums)
//            System.out.printf("%-3d",y);

        return (int) nums[n-1];
    }

    public static void main(String[] args) {
        /**
         * 添加是无序的，但是输出确实有序的
         * 有点懵
         */
//        Set<Integer> set = new HashSet<>();
//        set.add(2);
//        set.add(6);
//        set.add(1);
//        set.add(5);
//        set.add(4);
//        set.add(3);
//        Iterator<Integer> setIterator = set.iterator();
//        while(setIterator.hasNext()) {
//            int a = setIterator.next();
//            System.out.println(a);
//        }
        int n = 5,a = 2,b = 4;
       // System.out.println(nthMagicalNumber(n,a,b));
        System.out.println(gcd(12,16));
        int x = 100000000;
        int y = 40000;
        System.out.println(Integer.MAX_VALUE);
        long d = (long) x * y;
        System.out.println(d);
    }
}
