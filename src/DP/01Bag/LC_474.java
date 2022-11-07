//1和0
public class LC_474 {
    public static void main(String[] args) {
        String str[] = {"10","0001","111001","1","0"};
        int a = findMaxForm(str,1,1);
    }

    /**可以理解为有两个背包
     * 由滚动数组的一维 -》 二维
     * 原有的二维 -》 三维
     */
    public static int findMaxForm(String[] strs, int m, int n) {
        // dp[i][j]表示i个0和j个1时的最大子集
        int dp[][] = new int[m+1][n+1];
        for(String str:strs){
            int zeroNum = 0;
            int oneNum = 0;
            for(char ch:str.toCharArray()){
                if(ch=='0') zeroNum++;
                else oneNum++;
            }
            for(int i=m;i>=zeroNum;i--)
                for(int j=n;j>=oneNum;j--)
                    dp[i][j] = Math.max(dp[i][j],dp[i-zeroNum][j-oneNum]+1);
        }
        return dp[m][n];
    }


    //m个0 n个1 这么写是有问题的
    public static int findMaxForm2(String[] strs, int m, int n) {
        int len = strs.length;
        int volume1[] = new int[len]; //1的个数
        int volume0[] = new int[len]; //0的个数

        for(int i=0;i<len;i++){
            String str = strs[i];
            int len2 = str.length();
            //0的数目为原长度-将0替换为""后的长度
            volume0[i] = len2 - str.replace("0","").length();
            volume1[i] = len2 - volume0[i];
        }

        /**
         * dp0[i]表示凑成i个0的最大子集的长度
         * dp1[i]表示凑成i个1的最大子集的长度
         */
        int dp0[] = new int[m+1];
        int dp1[] = new int[n+1];
        dp0[0] = 0;
        dp1[0] = 0;
        //遍历volume
        for(int i=0;i<len;i++){
            for(int j=m;j>=volume0[i];j--){
                dp0[j] = Math.max(dp0[j],dp0[j-volume0[i]]+1);
            }

            for(int k=n;k>=volume1[i];k--){
                dp1[k] = Math.max(dp1[k],dp1[k-volume1[i]]+1);
            }
        }

        return Math.min(dp0[m],dp1[n]);
    }
}
