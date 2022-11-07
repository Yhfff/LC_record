package BackTrack;

import java.util.ArrayList;
import java.util.List;

//电话号码的字母组合

public class LC_17
{
    static List<String> ans = new ArrayList<>();// 全局变量
    static String map[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"}; //使用数组进行映射

    public static void main(String[] args)
    {
        String digits = "23";
        letterCombinations(digits);
        for(String str:ans)
            System.out.println(str);


    }

    public static List<String> letterCombinations(String digits)
    {
        //映射不一定使用map 使用数组也ok
//        Map<Character,String> map = new HashMap<>();  //这种定义需要放在main函数或者方法(这个猜的)里 直接放在外面会报错
//        map.put('2',"abc");
//        map.put('3',"def");
//        map.put('4',"ghi");
//        map.put('5',"jkl");
//        map.put('6',"mno");
//        map.put('7',"pqrs");
//        map.put('8',"tuv");
//        map.put('9',"wxyz");

//        for(Map.Entry entry:map.entrySet())
//            System.out.println(entry.getValue());
        if(digits.length()==0) return ans;
        backtrack(digits,0);
        return ans;
    }

    static StringBuilder sb = new StringBuilder();
    public static void backtrack(String digits,int curLen)
    {
        if (curLen == digits.length())
        {
            ans.add(sb.toString());  //字符串String StringBuilder不需要new String(path)
            return;
        }

        char key = digits.charAt(curLen);
        String val = map[key-'0']; //获取数字组合

        for (int i = 0; i < val.length(); i++) //从0开始 因为是不同组合的数据
        {
            sb.append(val.charAt(i));
            backtrack(digits,curLen+1);
            sb.deleteCharAt(sb.length()-1); //回溯
        }
    }

}
