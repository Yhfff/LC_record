package DailyProblem.December;

/**
 * 12.27 每日一题
 * 转换字符串的最少操作次数
 */
public class LC_2027_27 {
    public static int minimumMoves(String s) {
        int ans = 0;
        for(int i = 0;i < s.length();i++){
            System.out.println(i);
            if(s.charAt(i) == 'X'){
                ans ++;
                i += 2;
            }
            System.out.println(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "XXOX";
        System.out.println(minimumMoves(s));
    }
}
