package DailyProblem;

/**
 * 11.19每日一题
 * 找到最高海拔
 */
public class LC_1732 {
    public int largestAltitude(int[] gain) {
        int res = 0;
        int temp = 0;
        for(int i=0;i<gain.length;i++){
            temp += gain[i];
            res = Math.max(res,temp);
        }
        return res;
    }
}
