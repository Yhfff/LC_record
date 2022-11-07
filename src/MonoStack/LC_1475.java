package MonoStack;

import java.util.Stack;

/**
 * 9.1每日一题
 * 商品折扣后的最终价格
 */
public class LC_1475 {
    public static void main(String[] args) {

    }

    //单调栈
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<prices.length;i++){
            while(!stack.isEmpty() && prices[i]<=prices[stack.peek()]){
                prices[stack.peek()] -= prices[i];
                stack.pop();
            }
            stack.push(i);
        }
        return prices;
    }

    //在数组中 对于某一个元素 找第一个值小于等于该元素的元素  -》单调栈
    public int[] finalPrices2(int[] prices) {
        int len = prices.length;
        int res[] = new int[len];//为了节省空间内存 可以
        for(int i=0;i<len;i++){
            int discount = 0;
            for(int j=i+1;j<len;j++){
                if(prices[j]<=prices[i])
                {
                    discount=prices[j];
                    break;
                }
            }
            res[i] = prices[i] - discount;
        }
        return res;
    }
}
