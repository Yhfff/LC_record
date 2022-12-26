package DailyProblem.December;

/**
 * 12.26 每日一题
 * 统计同构子字符串的数目
 */
public class LC_1759_26 {
    private final int MOD = 1000000007;
    public int countHomogenous(String s) {
        //初始设置为1 因为是从第二个字符开始比较
        int ans = 1;
        // 统计连续相等的字符个数
        int cnt = 1;
        for(int i = 1;i < s.length();i++){
            if(s.charAt(i) == s.charAt(i-1)){
                cnt++;
            }else {
                cnt = 1;
            }
            ans = (ans + cnt) % MOD;
        }
        return ans % MOD;
    }

    public static int calSum(int n){
        int sum[] = new int[n+1];
        for(int i = 1;i <= n;i++)
            sum[i] = sum[i-1] + i;
        return sum[n];
    }

    public static void main(String[] args) {
        int max = Integer.MAX_VALUE;
//        System.out.println(max); // 2147483647 > 1e9 <1e10
//        System.out.println(1e10);// 10000000000
//        System.out.println(max > 1e10);
        System.out.println(calSum(1));

    }
}
