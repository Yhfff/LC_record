package BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//全排列2 给定的数组中有重复元素
public class LC_47
{

    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();
    static boolean[] used; //不需要使用startIndex 但需要借助used数组
    public static List<List<Integer>> permuteUnique(int[] nums)
    {
        //-10 <= nums[i] <=10
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums); //需要排序
        return res;

    }

    public static void backtrack(int []nums)
    {
        if(path.size() == nums.length)
        {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=0;i<nums.length;i++)
        {
            /*
            排列问题 树层去重和树枝去重都是可以的 但是树层效率更高
            used[i] = true 树枝去重
            used[i-1] = false 树层去重
             */
            if(used[i] || i>0 && nums[i]==nums[i-1] && used[i-1]==false)  //树层剪枝
                continue;
            used[i] = true;
            path.add(nums[i]);
            backtrack(nums);
            path.remove(path.size()-1);
            used[i] = false;
        }
    }




    public static void main(String[] args)
    {
        int nums[] = {1,2,1};
        res = permuteUnique(nums);
        for(List<Integer> list:res)
        {
            System.out.println(list);
        }
    }

}
