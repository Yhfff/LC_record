package BackTrack;

import java.util.ArrayList;
import java.util.List;

//组合总和3
public class LC_216
{
    static List<List<Integer>> res = new ArrayList<>(); //全局变量
    static List<Integer> combination = new ArrayList<>();
    public static void main(String[] args)
    {
        int k = 2, n = 18;
        List<List<Integer>> ans = combinationSum3(k,n);
        System.out.println(ans.size());
        for(List<Integer> list:ans)
        {
            System.out.println(list);
        }

    }

    public static List<List<Integer>> combinationSum3(int k, int n)
    {
        backtrack(k,n,0,1);
        return res;
    }

    public static void backtrack(int k,int n,int sum,int start)
    {
//        if(combination.size()==k && sum==n)  //一直递归
//        {
//            res.add(new ArrayList<>(combination));
//            return;
//        }
        if(sum>n)
            return;//总和sum已经大于目标和n 直接返回 也是一种剪枝操作
        if(combination.size()==k)
        {
            if(sum==n)
                res.add(new ArrayList<>(combination));
            return;//combination.size()==k 且sum!=n 也是直接返回
        }
        // sum n-sum i<=n-sum(不能这么剪枝 i的前提范围是1~9 n-sum会导致范围不对)
        //for(int i=start;i<=9-(k-combination.size())+1;i++)
        for(int i=start;i<=9-(k-combination.size())+1;i++)
        {
            sum = sum + i;
            combination.add(i);
            backtrack(k,n,sum,i+1);
            combination.remove(combination.size()-1);
            sum = sum - i; //sum也需要回溯 这种作为参数的 需要回溯？
        }
    }

}
