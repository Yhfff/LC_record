package Other;

import java.util.Arrays;

/**
 * 11.15 每日一题
 * 卡车上的最大单元数
 */
public class LC_1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int res = 0;
        /**
         * 第二列是单元数 按照第二列降序排列
         * 如果第二列一样 按第一列降序排列
         */
        Arrays.sort(boxTypes, (e1, e2)->(e1[1]==e2[1]?(e2[0]-e1[0]):(e2[1]-e1[1])));
        for(int i=0;i<boxTypes.length;i++){
            /**
             *  boxTypes[i][0]为箱子的数量
             *  boxTypes[i][1]为一个箱子的单元数
             */
            int cnt = boxTypes[i][0];
            if(truckSize>=cnt){
                res += cnt*boxTypes[i][1];
                truckSize -= cnt;
            }else {
                res += truckSize*boxTypes[i][1];
                return res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        /**
         * 第二列是单元数 按照第二列降序排列
         * 如果第二列一样 按第一列降序排列
         */
        int[][] boxTypes = {{5,10},{2,5},{4,7},{3,9},{4,5}};

        Arrays.sort(boxTypes, (e1, e2)->(e1[1]==e2[1]?(e2[0]-e1[0]):(e2[1]-e1[1])));

        for(int i=0;i<boxTypes.length;i++){
            for(int j=0;j<boxTypes[0].length;j++){
                System.out.printf("%-2d",boxTypes[i][j]);
            }
            System.out.println();
        }
    }
}
