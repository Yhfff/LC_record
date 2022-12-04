package DailyProblem.December;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 字符串中第二大的数字
 * 12.3 每日一题
 */
public class LC_1796_3 {
    //使用set去重
    public int secondHighest(String s) {
        Set<Integer> set = new TreeSet<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)-'0'>=0 && s.charAt(i)-'0' <=9 )
                set.add(s.charAt(i)-'0');
        }
        //if(set.size()==0 || set.size()==1) return -1;
        if(set.size()<2) return -1;
        else{
            int cnt = 0;
            //set.stream().sorted().toArray();  //使用流的方式将set转为数组
            for(int x:set){
                cnt++;
                if(cnt==set.size()-2)
                    return x;
            }
        }
        return -1;
    }

    //借助两个变量
    public int secondHighest2(String s){
        int first = -1, second = -1;
        for(int i = 0;i < s.length();i++){
            char chr = s.charAt(i);
            if(Character.isDigit(chr)){
                int tmp = chr - '0';
                if(tmp > first){
                    second = first;
                    first = tmp;
                }else if(tmp > second && tmp < first){ //tmp严格位于(second,first)
                    second = tmp;
                }
            }
        }
        return second;
    }
}
