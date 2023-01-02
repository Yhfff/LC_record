package DailyProblem.January;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 1.2 每日一题
 * 积压订单中的订单总数
 */
public class LC_1801_2 {
    private final int MOD = (int) (1e9 + 7);

    public int getNumberOfBacklogOrders(int[][] orders) {
        /**
         * 采购订单放置大根堆
         * 销售订单放置小根堆
         * 堆里面的元素是长度为2的数组 array[0] = price  array[1] = amount 不需要使用map
         */
        PriorityQueue<int[]> buyPQ= new PriorityQueue<>((o1, o2) -> (o2[0] - o1[0]));
        PriorityQueue<int[]> sellPQ = new PriorityQueue<>((o1, o2) -> (o1[0] - o2[0]));
        for(int[] order : orders){
            int price = order[0];
            int amount = order[1];
            int type = order[2];
            if(type == 0) {
                // 当前是采购订单
                while(amount > 0 && !sellPQ.isEmpty() && sellPQ.peek()[0] <= price){
                    // 删除销售订单
                    int[] sell = sellPQ.poll();
                    int p = sell[0], a = sell[1];
                    if(a > amount){
                        // 会将采购订单全部删除 如果采购数量不够删除销售订单 则将剩余的销售订单加入队列
                        sellPQ.add(new int[]{p, a - amount});
                        amount = 0;
                    }else {
                        amount -= a;
                    }
                }
                // 将剩余的采购订单添加至积压订单
                if(amount > 0){
                    buyPQ.add(new int[]{price, amount});
                }
            }else{
                // 当前是销售订单
                while(amount > 0 && !buyPQ.isEmpty() && buyPQ.peek()[0] >= price){
                    // 删除采购订单
                    int buy[] = buyPQ.poll();
                    int p = buy[0], a = buy[1];
                    if(a > amount){
                        buyPQ.add(new int[]{p, a - amount});
                        amount = 0;
                    }else {
                        amount -= a;
                    }
                }
                if(amount > 0){
                    sellPQ.add(new int[]{price, amount});
                }
            }
        }
        long ans = 0;
        while(!buyPQ.isEmpty()){
            ans += buyPQ.peek()[1];
            buyPQ.poll();
        }
        while(!sellPQ.isEmpty()){
            ans += sellPQ.peek()[1];
            sellPQ.poll();
        }

        return (int) (ans % MOD);
    }

}
