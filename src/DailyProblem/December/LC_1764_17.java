package DailyProblem.December;

/**
 * 12.17 每日一题
 * 通过连接另一个数组的子数组得到一个数组
 */
public class LC_1764_17 {
    public boolean canChoose(int[][] groups, int[] nums) {
        // i指向group k指向nums
        int gLen = groups.length;
        int i = 0;
        for(int k = 0;k < nums.length && i < gLen;){
            if(check(nums,groups[i],k)){
                // 保证不相交
                k += groups[i].length;
                i++;
            }else
                k++;
        }
        return i == gLen;
    }

    public boolean check(int[] nums, int[] group, int k){
        // nums剩余的长度不足以匹配group
        if((k + group.length) > nums.length)
            return false;
        for(int i = 0;i < group.length;i++){
            if(group[i] != nums[k])
                return false;
            else k++;
        }
        return true;
    }
//    public boolean canChoose(int[][] groups, int[] nums) {
//        int i = 0;
//        for(int tmp[]:groups){
//            int j = 0;
//            while(i < nums.length && j < tmp.length){
//                if(nums[i] == tmp[j]){
//                    i++;
//                    j++;
//                }else {
//                    i++;
//                }
//            }
//            if(i <= nums.length && j == tmp.length) continue;
//            else return false;
//        }
//        return true;
//    }
}
