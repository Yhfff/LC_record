package TwoPointer;

import org.omg.CORBA.MARSHAL;

/**
 * 接雨水
 * 双指针: 左边最高 + 右边最高(水桶效应？)
 * 这题还可以使用动态规划、单调栈去解
 */
public class LC_42 {
    public int trap(int[] height) {
        int res = 0;
        int maxLeft, maxRight;
        int len = height.length;
        for(int i=0;i<len;i++){
            //第一列和最后一列无法接雨水
            if(i==0||i==len-1) continue;
            maxLeft = height[i];
            maxRight = height[i];
            for(int j=0;j<=i-1;j++)
                maxLeft = Math.max(maxLeft,height[j]);
            for(int j=i+1;j<len;j++)
                maxRight = Math.max(maxRight,height[j]);
            res += Math.min(maxLeft,maxRight) - height[i];
        }
        return res;
    }
}
