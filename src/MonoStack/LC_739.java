package MonoStack;

import java.util.Stack;

/**
 * 每日温度
 * 可以与LC1475比较
 */
public class LC_739 {
    public static void main(String[] args) {
        int temperatures[] = {89,62,70,58,47,47,46,76,100,70};
        int res[] = dailyTemperatures(temperatures);
        for (int x:res) {
            System.out.printf("%-2d",x);
        }
    }


    /**
     * 单调栈-》
     * 1. 使用空间换时间 只需要一次for循环遍历就行
     * 2. 单词栈中存放下标即可 无需放值
     */
    //定义一个从栈头到栈底是递增的
    public static int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int res[] = new int[len];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<len;i++){
            //如果遇到的元素比栈顶元素大 说明栈顶元素右边第一个大于它的元素是temperatures[i]
            //注意使用下标
            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
                int index = stack.peek();  //获得栈顶元素对应的下标
                res[index] = i-index;
                stack.pop();
            }
            stack.push(i);  // 比栈顶元素小 直接入栈
        }
        return res;

    }



    //暴力  会超时的
    //在数组中 对于某一个元素 在该元素的右边 找第一个值大于该元素的元素 然后下标之差
    public static int[] dailyTemperatures2(int[] temperatures) {
        int len = temperatures.length;
        int res[] = new int[len];
        for(int i=0;i<len;i++){
            //不需要使用count 使用下标之差
            int cnt = 0;
            boolean flag = false;  //标记是否后续是否有大于的温度
            for(int j=i+1;j<len;j++){
                if(temperatures[j]<=temperatures[i]){
                    cnt++;
                }else {
                    flag = true;
                    cnt++;
                    break;
                }
            }
            if(flag)
                res[i] = cnt;
            else res[i] = 0;
        }
        return res;
    }
}
