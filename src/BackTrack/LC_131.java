package BackTrack;

import java.util.ArrayList;
import java.util.List;

//分割回文串
//切割问题也是一种组合问题
public class LC_131
{
    static List<List<String>> res = new ArrayList<>();
    static List<String> path = new ArrayList<>();
    public static void main(String[] args)
    {
        String s = "aab";
        //System.out.println(isHuiwen(s,0,s.length()-1));
        partition(s);
        for(List list:res)
            System.out.println(list);
    }


//
    public static List<List<String>> partition(String s)
    {
        backtrack(s,0);
        return res;
    }

    /*
    什么时候需要startIndex
    1. 如果一个集合求组合 需要startIndex
    2. 如果多个集合取组合，各个集合之间互相不影响，那么就不需要startIndex,如LC17
     */
    public static void backtrack(String s, int startIndex)
    {
        //说明此时已经找到了一组分割方案
        if(startIndex>=s.length())
        {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=startIndex;i<s.length();i++)
        {
            if(isHuiwen(s,startIndex,i))//说明是回文子串
            {
                //获取s中[startIndex,i]的子串 substring截取子串是左闭右开
                path.add(s.substring(startIndex,i+1));
            }else {
                continue;
            }
            backtrack(s,i+1);
            path.remove(path.size()-1);
        }
    }

    //双指针
    public static boolean isHuiwen(String str,int start,int end)
    {
        for(int i=start,j=end;i<j;i++,j--)
        {
            if(str.charAt(i)!=str.charAt(j))
                return false;
        }
        return true;
    }

    /*
    这一题的判断回文不能这么写
    因为这一题需要判断一个字符串里的子串是否是回文
    所以参数的设定应该要有子串的起始下标和终止下标
     */
    public static boolean isHuiwen2(String str)
    {
        int len = str.length();
        for(int i=0;i<len/2;i++)
        {
            if(str.charAt(i)!=str.charAt(len-i-1))
                return false;
        }
        return true;
    }
}
