package Competition.Week321;

/**
 * 找出中枢整数
 * LC_2485
 */
public class LC_2485 {
    //暴力
    public int pivotInteger(int n) {
        for(int i=1;i<=n;i++){
            int leftSum = 0, rightSum = 0;
            for(int j=1;j<=i;j++)
                leftSum += j;
            for(int k=i;k<=n;k++)
                rightSum += k;
            if(leftSum==rightSum) return i;
        }
        return -1;
    }

    //数学 等差数列和相等 O(1)复杂度
    public int pivotInteger2(int n) {
        int temp = n*n + n;
        /**
         *   判断一个数开根号后是否为整数
         *   1. res*res == temp
         *   2. 浮点数与取整后的数比较 ： double res == (int) res
         */
        int res = (int) Math.sqrt(temp);
        return res*res==temp?res:-1;
    }


    public static void main(String[] args) {
        System.out.println((int)Math.sqrt(10));
    }
}
