package Competition.Week321;

/**
 * 找出中枢整数
 */
public class LC_6245 {
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

    //O(1)复杂度
    public int pivotInteger2(int n) {
        int temp = n*n + n;
        int res = (int) Math.sqrt(temp);
        return res*res==temp?res:-1;
    }


    public static void main(String[] args) {
        System.out.println((int)Math.sqrt(10));
    }
}
