package HashTable;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_383
{
    //ransom能否由magazine构成  magazine中的每个字符只能用一次
    public static boolean canConstruct(String ransomNote, String magazine)
    {
        int len1 = ransomNote.length();
        int len2 = magazine.length();
        if(len2 < len1) return false;
        //key-value  字符-次数
        //使用map空间较大 可使用数组 record[26] 全部由小写字母构成
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<len2;i++)
        {
            char temp = magazine.charAt(i);
            if(map.containsKey(temp))
            {
                map.put(temp, map.get(temp)+1);
            }else
            {
                map.put(temp, 1);
            }
        }
        System.out.println(map);
        for(int j=0;j<len1;j++)
        {
            char temp = ransomNote.charAt(j);
            if(!map.containsKey(temp) || map.get(temp)==0)
                return false;
            else
                map.put(temp, map.get(temp)-1);
        }
        return true;
    }
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        String ransomNote = "aa";
        String magazine = "aab";
        boolean ans = canConstruct(ransomNote, magazine);
        System.out.println(ans);
    }
}
