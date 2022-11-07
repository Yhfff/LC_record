package BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//子集2
//可与LC_40进行对比
public class LC_90
{
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();
    public static void main(String[] args)
    {
        int[] nums = {4,6,7,7};
        res = subsets(nums);
        for(List<Integer> list:res)
        {
            System.out.println(list);
        }

    }

    public static List<List<Integer>> subsets(int[] nums)
    {
        //res.add(path); //先添加空集 因为空集是任何子集的空集
        Arrays.sort(nums);
        //下一次递归的时候 startIndex=i+1 其实不需要flag数组
        boolean flag[] = new boolean[nums.length];
        backtrack(nums,0,flag);
        return res;
    }


    public static void backtrack(int[] nums,int startIndex,boolean[] flag)
    {
        //递归终止条件
        res.add(new ArrayList<>(path)); //子集问题收集的是树的叶子节点 因此其实不需要终止条件

        if(startIndex>=nums.length)
            return;//可不加


        for(int i=startIndex;i<nums.length;i++)
        {
//            //对同一树层使用过的元素进行跳过
//            if(i>0 && nums[i]==nums[i-1] && flag[i-1]==false)
//                continue;
            //使用startIndex进行跳过
            if(i>startIndex && nums[i]==nums[i-1])
                continue;
            flag[i] = true;
            path.add(nums[i]);
            backtrack(nums,i+1,flag);
            path.remove(path.size()-1);
            flag[i] = false;
        }
    }
}
