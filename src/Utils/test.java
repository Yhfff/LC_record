package Utils;

public class test {
    public static int findLeftMax(int target,int nums[]){
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int mid = left + (right-left+1)/2;
            if(nums[mid]>target){
                //往左找 [0,mid-1]找
                right = mid-1;

            }else {//nums[mid]<=target
                //往右找 [mid,length-1]
                left = mid;
                //System.out.println(left);
            }
        }
        return nums[left];
    }

    public static int findRightMin(int target,int nums[]){
        int left = 0;
        int right = nums.length-1;//[0,length-1]查找
        while(left<right){
            int mid = left + (right-left)/2;
            if(nums[mid]<target){
                //往右找 [mid+1,length-1]查找 因为mid肯定不符合
                left = mid+1;
            }else { //nums[mid]>=target  有可能等于 所以mid不能舍去
                //往左找[0,mid]
                right=mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3,4,6,7,8,9};
        System.out.println(findLeftMax(5,nums));
        System.out.println(findRightMin(8,nums));

    }
}
