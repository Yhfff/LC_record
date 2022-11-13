package Other;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 11.13 每日一题
 * 自定义字符串排序
 */
public class LC_791 {
    public String customSortString(String order, String s) {
        /**
         * 1. 其实不一定需要使用map
         *    因为order和s中全是小写字母
         *   所以可以使用数组record[26] 其实会更方便
         * 2. 自定义排序
         */
        Map<Character,Integer> map = new HashMap<>();
        for(char chr:s.toCharArray()){
            map.put(chr,map.getOrDefault(chr,0)+1);
        }

        StringBuilder sb = new StringBuilder();
        for(char chr:order.toCharArray()){
            if(map.containsKey(chr)){
                int cnt = map.get(chr);
                for(int i=1;i<=cnt;i++)
                    sb.append(chr);
                map.remove(chr);
            }
        }

        for(Map.Entry<Character,Integer> entry: map.entrySet()){
            char chr = entry.getKey();
            int cnt = entry.getValue();
            for(int i=1;i<=cnt;i++)
                sb.append(chr);
        }

        return sb.toString();
    }
}
