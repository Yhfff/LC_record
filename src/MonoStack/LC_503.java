package MonoStack;

import java.util.Arrays;
import java.util.Stack;

//下一个最大元素2
public class LC_503 {
    public static void main(String[] args) {
        int nums[] = {1,2,1};
        int ans[] = nextGreaterElements(nums);
        for (int x:ans) {
            System.out.printf("%-4d",x);
        }
    }

    //nums是循环数组  循环——》取模
    public static int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int ans[] = new int[len];
        Arrays.fill(ans,-1);  //初始化为-1
        Stack<Integer> stack = new Stack<>();
        //遍历两遍nums数组  或者更为暴力将两个数组拼接: 新nums = nums + nums[]
        for(int i=0;i<len*2;i++){
            //注意使用下标
            while(!stack.isEmpty()&& nums[i%len]>nums[stack.peek()]){
                int index = stack.peek();  //获得栈顶元素对应的下标
                ans[index] = nums[i%len];
                stack.pop();
            }
            stack.push(i%len);  // 比栈顶元素小 直接入栈
        }
        return ans;
    }
}
