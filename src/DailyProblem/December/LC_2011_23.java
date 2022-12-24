package DailyProblem.December;

/**
 * 12.23 每日一题
 * 执行操作后的变量值
 */
public class LC_2011_23 {
    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        for(String operation : operations){
            switch (operation){
                case "++X":
                case "X++":
                    ans++;
                    break;
                case "--X":
                case "X--":
                    ans--;
                    break;
            }
        }
        return ans;
    }
}
