package DailyProblem.December;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 12.6 每日一题
 * LC_1805 字符串中不同整数的数目
 */
public class LC_1805_6 {
    public static int numDifferentIntegers(String word){
        Set<String> set = new HashSet<>();
        int len = word.length();
        for(int i = 0;i < len;i++){
            // 关键在于前导0的处理
            // 最终i会停在第一个不是0的数字下标
            if(Character.isDigit(word.charAt(i))){
                while(i < len && word.charAt(i) == '0')
                    i++;
                int j = i;
                while(j < len && Character.isDigit(j))
                    j++;
                //substring 前闭后开
                String tmp = word.substring(i, j);
                i = j;// 更新开始指针
                set.add(tmp);
            }
        }
        //当遇到0000c  word.substring(i, j)的结果会是一个空字符串 -》 0 所有结果也是对的
        for(String x:set)
            System.out.println(x);
        return set.size();
    }



    public static int numDifferentIntegers2(String word) {
        Set<Integer> set = new HashSet<>();
        int len = word.length();
        List<Integer> list = new LinkedList<>();
        for(int i = 0;i < len;i++){
            if(!Character.isDigit(word.charAt(i)))
                list.add(i);
        }
        list.add(len);
        int start = -1;
        for(int k = 0;k < list.size();k++)
        {
            int index = list.get(k);
            if((start + 1) >= index)
            {
                start = index;
                continue;
            }
            String tmp = word.substring(start+1, index);
            //直接使用Integer.parseInt去转 可能会出现溢出的问题 当字符串很长时 超出int能表示的范围
            set.add(Integer.parseInt(tmp));
            start = index;
        }
        return set.size();
    }

    public static void main(String[] args) {
        String s = "a123bc34d8ef34";
        // System.out.println(s.substring(1,1));
        numDifferentIntegers(s);

    }
}
