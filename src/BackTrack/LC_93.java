package BackTrack;

import java.util.ArrayList;
import java.util.List;


//复原IP地址
public class LC_93
{
    static List<String> res = new ArrayList<>();

    public static void main(String[] args)
    {
        String s = "101023";
        res = restoreIpAddresses(s);
        for(String str:res)
            System.out.println(str);
    }

    public static List<String> restoreIpAddresses(String s)
    {
        if(s.length()<4 || s.length()>12) return res; //相当于剪枝
        backtrack(s,0,0);
        return res;
    }

    //因为合格的ip地址只有四部分且有3个点 因此只需要割3次
    //因此backtrack中的参数要再设一个dotNum记录点的数量，并以dotNum==3为递归终止条件
    public static void backtrack(String s,int startIndex,int dotNum)
    {
        if(dotNum==3)
        {
            //判断第四段
            if(judge(s,startIndex,s.length()-1))
            {
                res.add(s);
            }
            return;
        }

        for(int i=startIndex;i<s.length();i++)
        {
            if(judge(s,startIndex,i))
            {
                s = s.substring(0,i+1) + "." + s.substring(i+1); //直接修改s
                dotNum++;
                backtrack(s,i+2,dotNum); //由于插入了. 因此startIndex的值应该更新为i+2
                dotNum--;
                s = s.substring(0,i+1) + s.substring(i+2); //将点取消
            }else
            {
                break; //为什么用break 不用continue 需要思考 和LC_131比较
            }
        }
    }


    public static boolean judge(String s,int start,int end)
    {
        //这个判断条件是必须的 s = "101023"
        //可能是因为backtrack()递归的时候 i=i+2 使得startIndex的值超过了s.length 如果不进行判断，会扔出异常
        if(start>end)
            return false;

        //判断是否有前导0
        if(s.charAt(start)=='0' && start!=end)
            return false;

        //值是否在0~255中间
        int num = 0;
        for(int i=start;i<=end;i++)
        {
            int temp = s.charAt(i) - '0';
            num = 10 * num + temp;
            if (num > 255)
                return false;
        }
        return true;
    }

}
