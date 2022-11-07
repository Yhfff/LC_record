package BackTrack;

import java.util.ArrayList;
import java.util.List;

//子集
public class LC_78
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
        backtrack(nums,0);
        return res;
    }


    public static void backtrack(int[] nums,int startIndex)
    {
//        for(int i=1;i<nums.length;i++)
//        {
//            if(path.size()==i)
//            {
//                res.add(new ArrayList<>(path));
//                return;
//            }
//        }
        //递归终止条件
        //收集子集，要放在终止添加的上面，否则会漏掉自己
        res.add(new ArrayList<>(path)); //子集问题收集的是树的叶子节点 因此其实不需要终止条件

        if(startIndex>=nums.length)
            return;//可不加


        for(int i=startIndex;i<nums.length;i++)
        {
            path.add(nums[i]);
            backtrack(nums,i+1);
            path.remove(path.size()-1);
        }
    }
}
