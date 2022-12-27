package BinarySearch;

import java.util.Arrays;

/**
 * 两球之间的磁力
 * 二分
 * 与LC_2517基本相同
 */
public class LC_1552 {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int len = position.length;
        int ans = -1;
        //左闭右闭  [left, right]
        int left = 1, right = position[len-1] - position[0];
        while(left <= right){
            int mid = left + (right - left)/2;
            if(check(mid,position,m)){
                ans = mid;
                left = mid + 1;
            }else
                right = mid - 1;
        }
        return ans;
    }

    public boolean check(int target, int[] position, int m) {
        // cnt设置为1 首先在第0个位置放一个
        int cnt = 1;
        int pre = position[0];
        for (int i = 1; i < position.length; i++){
            if(position[i] - pre >= target) {
                cnt++;
                pre = position[i];
            }
        }
        return cnt >= m;
    }
}
