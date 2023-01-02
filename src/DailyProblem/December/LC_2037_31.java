package DailyProblem.December;

import java.util.Arrays;

/**
 * 12.31 每日一题
 * 使每位学生都有座位的最少移动次数
 * 排序
 */
public class LC_2037_31 {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int ans = 0;
        for(int i = 0;i < seats.length;i++)
            ans += Math.abs(seats[i] - students[i]);
        return ans;
    }
}
