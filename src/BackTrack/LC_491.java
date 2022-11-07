package BackTrack;

import java.util.ArrayList;
import java.util.List;

//递增子序列
public class LC_491
{
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();
    public static void main(String[] args)
    {
        int[] nums = {4,6,7,7};
        res = findSubsequences(nums);
        for(List<Integer> list:res)
        {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> findSubsequences(int[] nums)
    {

        backtrack(nums,0);
        return res;
    }

    public static void backtrack(int[] nums,int startIndex)
    {
        //递归终止条件 不要加return 要取树上的节点  只取叶子节点的话 是需要return的
        if(path.size()>=2)
            res.add(new ArrayList<>(path));

        /*
        本题也需要去重，但是不能排序，因为求的是递增子序列，如果排序之后就都是递增子序列了
        因此 可以选择使用set去重 但其实可用数组实现 -100<=nums[i]<=100
         */
        int used[] = new int[201];  //此used只负责本层 每次backtrack都重定义一下
        for(int i=startIndex;i<nums.length;i++)
        {
            if((!path.isEmpty() && nums[i]<path.get(path.size()-1)) || used[nums[i]+100]==1)
                continue;
            used[nums[i]+100] = 1; //注意是下标是nums[i]+100
            path.add(nums[i]);
            backtrack(nums,i+1);
            path.remove(path.size()-1);
            //used[nums[i]+100] = 0;   之前需要这一步 是因为此前经过了排序？
        }
    }
}
