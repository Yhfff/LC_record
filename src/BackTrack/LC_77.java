package BackTrack;

import java.util.ArrayList;
import java.util.List;

//组合
public class LC_77
{
    //或者也可将res path定义为全局变量 这样回溯函数里就少两个参数
    public static List<List<Integer>> combine(int n, int k)
    {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        //LinkedList<Integer> path = new LinkedList<>();
        backtrack(1,n,k,res,path);
        return res;
    }
    //回溯
    public static void backtrack(int start,int n,int k,List<List<Integer>> res,List<Integer> path)
    {
        if(path.size()==k)
        {
            //res.add(path);
            /*
            res.add(new ArrayList(path))：开辟一个独立地址，地址中存放的内容为path链表，后续path的变化不会影响到res
            res.add(path)：将res尾部指向了path地址，后续path内容的变化会导致res的变化
             */
            res.add(new ArrayList<>(path));
            //res.add(new LinkedList<>(path));
            return;
        }
        //起始范围要收缩 终止范围也不是固定的
        //for(int i=start;i<=n;i++)
        for(int i=start;i<=n- (k-path.size())+1;i++)  //剪枝优化 至多从n- path.size()+1开始搜锁 否则没有意义 将其剪枝
        {
            path.add(i);
            backtrack(i+1,n,k,res,path);
            path.remove(path.size()-1);
        }
    }

    //剪枝

    public static void main(String[] args)
    {
        int n = 1,k = 1;
        List<List<Integer>> ans = combine(n,k);
        System.out.println(ans.size());
        for(List<Integer> list:ans)
        {
            System.out.println(list);
        }
    }
}
