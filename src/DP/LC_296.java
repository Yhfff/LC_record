package DP;

//不同的二叉搜索树
public class LC_296 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(numTrees(n));
    }


    /**
     * 卡特兰数
     * 令h(0)=1,h(1)=1，catalan数满足递推式:
     * h(n)= h(0)*h(n-1)+h(1)*h(n-2) + ... + h(n-1)h(0) (n>=2)
     */
    public static int numTrees(int n) {
        int dp[] = new int[n+1];  //dp[i]表示1-i能构成多少种二叉搜索树
        dp[0] = 1;  //空树也算一种情况
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++)
                dp[i] += dp[j]*dp[i-j-1];
        }
        /**
         * 以n=3为例  只需要考虑树的排列方式 不需要关注具体的值
         * 1. 以1为根结点 2 3只能位于右子树 左子树为空 dp[0]*dp[2]
         * 2. 以2为根结点 1 3各位于左右子树 dp[1]*dp[1]
         * 3. 以3为根结点  1 2只能位于左子树 右子树为空 dp[2]*dp[0]
         *
         * dp[3] = dp[0]*dp[2] + dp[1]*dp[1] + dp[2]*dp[0]
         * dp[i] = dp[0]*dp[i-1] + dp[1]*dp[i-2] ...... + dp[i-1]*dp[0]
         */
        return dp[n];
    }
}
