package Competition.Week325;

import java.util.Arrays;

/**
 * 325周赛 P3
 * 礼盒的最大甜蜜度
 */
public class LC_2517 {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int len = price.length;
        int ans = 0;
        //左闭右闭  [left, right]
        int left = 1, right = price[len-1] - price[0];
        while(left <= right){
            int mid = left + (right - left)/2;
            if(check(mid,price,k)){
                ans = mid;
                left = mid + 1;
            }else
                right = mid - 1;
        }
        return ans;
    }

    public boolean check(int target, int[] price, int m) {
        int cnt = 1;
        int pre = price[0];
        for (int i = 1; i < price.length; i++){
            if(price[i] - pre >= target) {
                cnt++;
                pre = price[i];
            }
        }
        return cnt >= m;
    }
}
