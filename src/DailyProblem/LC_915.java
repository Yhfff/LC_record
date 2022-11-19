package DailyProblem;

import java.util.*;

/**
 * 10.24每日一题
 * 分割数组
 */
public class LC_915 {
    public static void main(String[] args) {
        int nums[] = {1,1,1,0,6,12};
//        int max = Arrays.stream(nums).max().getAsInt();
//        int min = Arrays.stream(nums).min().getAsInt();
//        System.out.println(max);
//        System.out.println(min);
        System.out.println(partitionDisjoint3(nums));
    }

    //前缀最大值+后缀最小值
    public static int partitionDisjoint(int[] nums) {
        int len = nums.length;
        //min[i]表示[i,len)范围内的最小值   即后缀最小值
        int min[] = new int[len];
        min[len-1] = nums[len-1];  //提前赋值min[len-1]
        for(int i=len-2;i>=0;i--){
            min[i] = Math.min(nums[i],min[i+1]);
        }

        int max = -1;//记录[0,j)范围内的最大值  即前缀最大值
        for(int j=0;j<len;j++){
            max = Math.max(max,nums[j]);
            if(max<=min[j+1]) //符合条件
                return j+1;
        }
        return -1;
    }

    //一次遍历
    public static int partitionDisjoint3(int[] nums) {
        int len = nums.length;
        int curMax = nums[0],leftMax=nums[0],leftPos=0;
        for(int i=1;i<len;i++){
            if(nums[i]>=leftMax){
                curMax = Math.max(nums[i],curMax);//当前遇到的最大值
            }else {  //比leftMax还小的 肯定位于左边
                leftPos = i;
                leftMax = curMax;   //左边的max改为当前遇到的最大值
            }
        }
        return leftPos + 1;
    }


    //超时
    public static int partitionDisjoint2(int[] nums) {
        int len = nums.length;
        int res = 0;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for(int i=1;i<len;i++)  //i: [1,len-1]
        {
            for(int j=0;j<i;j++)  //[0,i)
                left.add(nums[j]);
            for(int k=i;k<=len-1;k++) //[i,len)
                right.add(nums[k]);
            //left的最大值小于right的最小值
            int max = Collections.max(left);
            int min = Collections.min(right);
            if(max<=min)
            {
                res = i;
                break;
            }
            //记得清空left与right
            left.clear();
            right.clear();
        }
        return res;
    }
}
