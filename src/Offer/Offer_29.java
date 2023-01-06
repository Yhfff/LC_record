package Offer;

import java.util.Collections;

/**
 * Offer_29 顺时针打印矩阵
 * 与LC_54相同
 */
public class Offer_29 {
    public int[] spiralOrder(int[][] matrix) {
        // 当matrix为空时 matrix.length不会报错 但是matrix[0].length会报错
        int m = matrix.length;
        if(m == 0) return new int[0];
        int n = matrix[0].length;
        int index = 0;
        int ans[] = new int[m * n];
        int left = 0, right = n - 1, top = 0, bottom = m - 1;
        while(true){
            // 从左往右
            for(int i = left;i <= right;i++)
                ans[index++] = matrix[top][i];
            //下一步 要从上往下 如果越界 直接break 同时 ++top 将上边界收缩
            if(++top > bottom) break;
            // 从上往下
            for(int i = top;i <= bottom;i++)
                ans[index++] = matrix[i][right];
            // 下一步 要从右往左
            if(--right < left) break;
            // 从右往左
            for(int i = right;i >= left;i--)
                ans[index++] = matrix[bottom][i];
            // 下一步 要从下往上
            if(--bottom < top) break;
            // 从下往上
            for(int i = bottom;i >= top;i--)
                ans[index++] = matrix[i][left];
            // 下一步 要从左往右
            if(++left > right) break;
        }
        return ans;

    }
}
