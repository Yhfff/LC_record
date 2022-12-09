package DailyProblem.December;

import java.util.ArrayList;
import java.util.List;

/**
 * 12.9 每日一题
 * 判断一个数字是否可以表示成三的幂的和
 */
public class LC_1780_9 {
    // 三进制 转化为3进制后，每一位必须是0或1，出现2的话返回false
    public boolean checkPowersOfThree(int n){
        while(n>0){
            if(n%3 == 2) return false;
            else
                n = n/3;
        }
        return true;
    }


    // 超时 120/129
    public boolean checkPowersOfThree2(int n){
        int len = 15;
        int options[] = new int[len]; //pow(3,15)>1e7
        for(int i=0;i<len;i++)
            options[i] = (int)Math.pow(3,i);
        int dp[] = new int[n + 1];

        for(int i=0;i<len;i++){
            for(int j=n;j>=options[i];j--)
                dp[j] = Math.max(dp[j], dp[j-options[i]]+options[i]);
        }
        return dp[n] == n;
    }

    //dfs
    public boolean checkPowersOfThree3(int n) {
        int options[] = new int[15]; //pow(3,15)>1e7
        for(int i=0;i<15;i++)
            options[i] = (int)Math.pow(3,i);
        return dfs(options,0,n,0);
    }

    public boolean dfs(int options[], int sum, int target, int start){
        if(sum == target) return true;
        if(sum > target) return false;
        for(int i=start;i<options.length;i++){
            if(dfs(options, sum+options[i], target, i+1))
                return true;
        }
        return false;
    }


    //回溯
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public boolean checkPowersOfThree4(int n) {
        int options[] = new int[15]; //pow(3,15)>1e7
        for(int i=0;i<15;i++)
            options[i] = (int)Math.pow(3,i);
        backtrack(options,0,n,0);
        return res.size()>0;
    }

    public void backtrack(int options[], int sum, int target, int start){
        if(sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        //这一步需要加 即剪枝 否则可能会超时
        if(sum > target) return;

        for(int i=start;i<options.length;i++){
            sum = sum + options[i];
            path.add(options[i]);
            backtrack(options, sum, target,i+1);
            path.remove(path.size()-1);
            sum = sum - options[i];
        }
    }

    public static void main(String[] args) {
        System.out.println(Math.pow(3,14));
    }
}
