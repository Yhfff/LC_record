package BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//组合
public class LC_39
{
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    public static void main(String[] args)
    {
        int candidates[] = {1,2,5};
        int target = 5;
        res = combinationSum(candidates,target);
        for(List<Integer> list:res)
        {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        Arrays.sort(candidates);  //需要排序
        backtrack(candidates,target,0,0); //start参数是需要的 否则要去重
        return res;
    }
    /*
    candidates[] = {2,3,5} target = 8
    Output:
        [2, 2, 2, 2]
        [2, 3, 3]
        [3, 2, 3]
        [3, 3, 2]
        [3, 5]
        [5, 3]
     因此需要去重
     加上start就可以
     */

    /*
    其实可以不用sum 直接用target-- 然后判断是否等于0即可
     */
    public static void backtrack(int[] candidates,int target,int sum,int start)
    {
        //if(sum>target) return; //剪枝 但实际上还是进入了递归

        if(sum==target)
        {
            res.add(new ArrayList<>(path));
            return;
        }
        //剪枝
        // for(int i=start;i<candidates.length;i++)
        // sum+candidates[i]<=target 如果加上下一个的和大于target 直接跳过 不进入递归  这样的话 是需要对candidates排序的
        for(int i=start;i<candidates.length && sum+candidates[i]<=target;i++)
        {
            sum += candidates[i];
            path.add(candidates[i]);
            backtrack(candidates,target,sum,i);//start=i 而不是i+1 这样下次递归还能选择这个数
            path.remove(path.size()-1);
            sum -= candidates[i];
        }
    }
}
