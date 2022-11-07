
package DP;

/**
 * 背包问题的理解
 */
public class Bag {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagSize = 4;
        System.out.println(BagSolution2(weight, value, bagSize));
    }

    //二维数组
    public static int BagSolution(int[] weight, int[] value, int bagSize){
        int len = weight.length; //物品的数量
        //dp[i][j]表示从[0,i-1]的物品 容量为j的最大价值  dp[len-1][bagSize]
        int dp[][] = new int[len][bagSize+1];
        //初始化  对于第0号物品  《《--- dp[i-1][j]  dp是从上方推导
        for(int i=1;i<=bagSize;i++){
            if(i>=weight[0]) dp[0][i] = value[0];
        }

        //以物品顺序遍历
        for(int i=1;i<len;i++)
        {
            for(int j=1;j<=bagSize;j++)  //遍历背包容量
            {
                //容量可以装下物品i
                if(j>=weight[i]){
                    dp[i][j] = Math.max(dp[i-1][j-weight[i]]+value[i],dp[i-1][j]);
                }else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[len-1][bagSize];
    }

    //滚动数组
    public static int BagSolution2(int[] weight, int[] value, int bagSize){
        int len = weight.length;//物品的数量
        //dp[i]表示背包容量为i时的最大容量
        int dp[] = new int[bagSize+1];

        //遍历物品
        for(int i=0;i<len;i++){
            //倒序遍历背包容量 不可以正序遍历
            for(int j=bagSize;j>=weight[i];j--){
                dp[j] = Math.max(dp[j],dp[j-weight[i]]+value[i]);
            }
        }


        return dp[bagSize];


    }

}
