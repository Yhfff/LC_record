package BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//全排列
public class LC_46
{
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();
    static boolean[] used; //不需要使用startIndex 但需要借助used数组
    public static List<List<Integer>> permute(int[] nums)
    {
        //-10 <= nums[i] <=10
        used = new boolean[nums.length];
        backtrack(nums);
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
            if(used[i])  //一次排列只能用一次
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
        int nums[] = {1,2,3};
        res = permute(nums);
        for(List<Integer> list:res)
        {
            System.out.println(list);
        }
    }
}
