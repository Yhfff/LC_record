package DailyProblem.January;

/**
 * 1.6 每日一题
 * 统计各位数字之和为偶数的整数个数
 */
public class LC_2180_6 {
    // 转成字符串 或者 除10取余
    public int countEven(int num) {
        int ans = 0;
        for(int i = 1;i <= num;i++){
            String numStr = String.valueOf(i);
            int tmp = 0;
            for(char chr : numStr.toCharArray())
                tmp += chr - '0';
            if(tmp % 2 == 0) ans++;
        }
        return ans;
    }
}
