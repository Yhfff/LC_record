package Competition.Week317;

/**
 * Problem1
 * 对数组执行操作
 */
public class LC_6229 {

    public static void main(String[] args) {
        int[] nums = {1,2,2,1,1,0};
        int[] res = applyOperations(nums);
        for (int x: res) {
            System.out.printf("%-2d",x);
        }
    }

    public static int[] applyOperations(int[] nums) {
        int len = nums.length;
        for(int i=0;i<len-1;i++){
            if(nums[i]==nums[i+1]){
                nums[i] *= 2;
                nums[i+1] = 0;
            }
        }
        //将所有的0移到末尾
        int res[] = new int[len];
        int cnt = 0;
        for(int i=0;i<len;i++){
            if(nums[i]!=0){
                res[cnt++] = nums[i];
            }
        }
        return res;
    }
}
