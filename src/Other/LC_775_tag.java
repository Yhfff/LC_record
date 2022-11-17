package Other;

/**
 * 11.16每日一题
 * 全局倒置与局部倒置
 */
public class LC_775_tag {
    public static boolean isIdealPermutation(int[] nums) {
        int len = nums.length;
        if(len==1) return true;

        int globalCnt = 0;
        int partCnt = 0;

        //求局部倒置的数量
        for(int i=0;i<len-1;i++)
        {
            if(nums[i]>nums[i+1])
                partCnt++;
        }

        /**
         * 求全局倒置的数量(逆序对)
         * 暴力双重循环肯定超时 O(n^2)
         *
         */
        for(int i=0;i<len-1;i++){
            for(int j=i+1;j<len;j++){
                if(nums[i]>nums[j])
                    globalCnt++;
            }
        }

        System.out.println(globalCnt);
        System.out.println(partCnt);

        return globalCnt==partCnt;
    }

    public static void main(String[] args) {
        int nums[] = {1,0,2};
        System.out.println(isIdealPermutation(nums));
    }
}
