package DailyProblem;


import java.util.ArrayList;
import java.util.List;
//10.11 每日一题
//仅执行一次字符串交换能否使两个字符串相等
public class LC_1790 {
    public static void main(String[] args) {
        String s1 = "bank";
        String s2 = "kanb";
        System.out.println(areAlmostEqual(s1,s2));
    }

    public static boolean areAlmostEqual(String s1, String s2)
    {
        int a = -1,b = -1; //a记录第一个不同位置的下标 b记录第二个不同位置的下标
        for(int i=0;i<s1.length();i++)
        {
            if(s1.charAt(i)==s2.charAt(i)) continue;
            if(a==-1) a = i;//a记录第一个位置
            else if(b==-1) b = i; //b记录第二个位置
            else return false;//说明有第三个不同的位置 直接返回false
        }
        if(a==-1) return true;// 说明两个字符串相等
        if(b==-1) return false;//说明只有一个位置不相同
        return (s1.charAt(a)==s2.charAt(b)) && (s1.charAt(b)==s2.charAt(a));
    }


    public static boolean areAlmostEqual2(String s1, String s2) {
        if(s1.equals(s2)) return true;

        int len = s1.length();
        int count=0;
        //char[] a = new char[4];
        List<Character> a = new ArrayList<>();
        int j=0;
        for(int i=0;i<len;i++)
        {
            if(s1.charAt(i)!=s2.charAt(i))
            {
                count++;
                a.add(s1.charAt(i));
                a.add(s2.charAt(i));
            }
        }
        if(count==2&&(a.get(0)==a.get(3)) && (a.get(1)==a.get(2)))
            return true;
        else return false;
    }

}
