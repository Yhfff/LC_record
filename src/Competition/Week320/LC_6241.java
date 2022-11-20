package Competition.Week320;

/**
 * 数组中不等三元组的数目
 */
public class LC_6241 {
    public int unequalTriplets(int[] nums) {
        int res = 0;
        int len = nums.length;
        for(int i=0;i<len-2;i++){
            for(int j=i+1;j<len-1;j++){
                for(int k=j+1;k<len;k++){
                    if(nums[i]!=nums[j] && nums[i]!=nums[k] && nums[j]!=nums[k])
                        res++;
                }
            }
        }
        return res;
    }
}
