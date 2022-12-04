package DailyProblem.December;

import java.util.Arrays;

/**
 * 12.4每日一题
 * 最接近目标价格的甜点成本
 */
public class LC_1774_4 {
    int ans;
    //dfs
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        //初始设为baseCosts的最小值
        ans = Arrays.stream(baseCosts).min().getAsInt();
        for(int baseCost : baseCosts){
            dfs(baseCost,0, toppingCosts,target);
        }
        return ans;
    }

    public void dfs(int sum, int start, int[] toppingCosts ,int target){
        int cur = Math.abs(sum - target), pre = Math.abs(ans - target);
        if(cur < pre) ans = sum;
        //因为判断的是绝对值 比如target=10 cur=pre=2 sum=12 ans=8
        if(cur == pre && sum < ans) ans = sum;
        //if(start==toppingCosts.length) return;
        if(sum > target) return;
        //在dfs中不要使用for(Int x: top)进行遍历
        for(int i = start;i < toppingCosts.length;i++){
            /**
             * 三种选择
             * 1. 不选  2. 一个  3. 两个
             */
            dfs(sum,i+1,toppingCosts,target);
            dfs(sum+toppingCosts[i],i+1, toppingCosts,target);
            dfs(sum+toppingCosts[i]*2, i+1, toppingCosts,target);
        }
    }


}
