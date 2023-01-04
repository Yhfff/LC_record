package DailyProblem.January;

/**
 * 1.4 每日一题
 * 有界数组中指定下标处的最大值
 */
public class LC_1802_4 {
    public int maxValue(int n, int index, int maxSum) {
        int left = 1, right = maxSum;
        int ans = -1;
        // 二分 左闭右闭 [left, right]
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(cal(mid - 1, index) + cal(mid, n - index) <= maxSum){
                ans = mid;
                left = mid + 1;
            }else
                right = mid - 1;
        }
        return ans;
    }

    // 需要将mid定义为long类型
    public long cal(long mid, int cnt){
        if(mid >= cnt)
            return cnt * (2 * mid - cnt + 1) / 2;
        else
            return mid * (mid + 1) / 2 + cnt - mid;
    }

}
