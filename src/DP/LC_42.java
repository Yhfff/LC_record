package DP;

/**
 * 接雨水
 * 动态规划
 */
public class LC_42 {
    public int trap(int[] height) {
        int res = 0;
        int len = height.length;
        int maxLeft[] = new int[len];
        int maxRight[] = new int[len];
        maxLeft[0] = height[0];
        for(int i=1;i<len;i++)
            maxLeft[i] = Math.max(height[i],maxLeft[i-1]);
        maxRight[len-1] = height[len-1];
        for(int j=len-2;j>=0;j--)
            maxRight[j] = Math.max(height[j],maxRight[j+1]);

        for(int i=0;i<len;i++){
            if(i==0 || i==len-1) continue;
            res += Math.min(maxLeft[i],maxRight[i]) - height[i];
        }

        return res;
    }
}

