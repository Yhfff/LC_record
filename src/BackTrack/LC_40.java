package BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//组合2
public class LC_40
{
    /*
    相比于组合
    (1) 每个数字在每个组合中只能使用一次
    (2) 数组candidates的元素是有重复的，但是解集不能有重复的组合

    1. 树枝去重  2. 树层去重
    去重前需要排序
     */

    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    public static void main(String[] args)
    {
        int candidates[] = {10,1,2,7,6,1,5};
        int target = 8;
        res = combinationSum2(candidates,target);
        for(List<Integer> list:res)
        {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target)
    {
        Arrays.sort(candidates);  //需要排序
        //加入标记数组
        boolean[] flag = new boolean[candidates.length];

        backtrack(candidates,target,0,0,flag); //start参数是需要的 否则要去重
        return res;
    }


    /*
    其实可以不用sum 直接用target-- 然后判断是否等于0即可
     */
    public static void backtrack(int[] candidates,int target,int sum,int start,boolean[] flag)
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
            /*
             判断是否出现重复节点
             candidates[i]==candidates[i-1] && flag[i-1]==false 说明前一个树枝使用了candidates[i-1]
                                                                    同一个树层使用了candidates[i-1]
             flag[i-1] = true 同一树枝candidates[i-1]用过
             flag[i-1] = false 同一树层candidates[i-1]用过
             */
            if(i>0 && candidates[i]==candidates[i-1] && flag[i-1]==false)
            {
                continue; //直接下个循环
            }
            flag[i] = true;
            sum += candidates[i];
            path.add(candidates[i]);
            backtrack(candidates,target,sum,i+1,flag);
            path.remove(path.size()-1);
            sum -= candidates[i];
            flag[i] = false;
        }
    }


}
