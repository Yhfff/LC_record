package Offer;

/**
 * 剑指Offer4
 * 二维数组上的查找
 */
public class Offer_4 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 从左下角开始搜索
        int i = matrix.length - 1, j = 0;
        while(i >= 0 && j < matrix[0].length){
            if(matrix[i][j] > target){
                i--;
            }else if(matrix[i][j] < target){
                j++;
            }else
                return true;
        }
        return false;
    }

    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        // 从右上角开始搜索
        int i = 0, j = matrix[0].length - 1;
        while(i < matrix.length && j >= 0){
            if(matrix[i][j] > target){
                j--;
            }else if(matrix[i][j] < target){
                i++;
            }else
                return true;
        }
        return false;
    }
}
