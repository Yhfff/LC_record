package MonoStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

//下一个更大元素1
public class LC_496 {
    public static void main(String[] args) {
        int nums1[] = {4,1,2};
        int nums2[] = {1,3,4,2};
        int res[] = nextGreaterElement(nums1,nums2);

        for (int x: res) {
            System.out.printf("%-3d",x);
        }

    }

    /**
     * nums1[]是nums2[]的子集
     * 数组中没有重复元素
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        HashMap<Integer,Integer> map = new HashMap<>(); //使用map来减少后续二重查找时间
        int ans[] = new int[len1];
      //  int res[] = new int[len2];
        Arrays.fill(ans,-1);  //初始化为-1
        Stack<Integer> stack = new Stack<>();

        /**
         * 我们需要的是下标
         * 因为key：nums1[i]  value:下标
         */
        for(int i=0;i<len1;i++)
            map.put(nums1[i],i);

        for(int i=0;i<len2;i++){
            //找下一个更大元素
            while (!stack.empty() && nums2[i]>nums2[stack.peek()]){
                //用判断这个元素在不在nums1中 如果存在
                if(map.containsKey(nums2[stack.peek()])){
                    int index = map.get(nums2[stack.peek()]); //获取这个数在nums1中的下标
                    ans[index] = nums2[i];
                }
                stack.pop();
            }
            stack.add(i);
        }

//        for(int i=0;i<len1;i++){
//            int temp = nums1[i];
//            for (int j=0;j<len2;j++){
//                if(nums2[j]==temp){
//                    ans[i] = (res[j]==0)?-1:res[j];
//                    break;
//                }
//            }
//        }



        return ans;
    }
}
