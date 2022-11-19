package MonoStack;

import java.util.Stack;

/**
 * 接雨水
 */
public class LC_42 {
    /**
     *  找下一个大于等于height[i]的元素
     *  有问题
     */
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int len = height.length;
        boolean visited[] = new boolean[len];
        for(int i=0;i<len;i++){
            if(height[i]==0) continue;
            if(visited[i]) continue;
            visited[i] = true;
            while(!stack.isEmpty() && height[i]>=height[stack.peek()]){
                int index = stack.peek();
                for(int j=index;j<i;j++){
                    visited[j] = true;
                    res += height[index] - height[j];
                }
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
}
