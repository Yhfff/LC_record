package HashTable;

public class LeetCode_242
{
    public static boolean isAnagram(String s, String t)
    {
        int s_len = s.length();
        int t_len = t.length();
        if(s_len!=t_len)
            return false;
        int record[] = new int[26];
        for(int i=0;i<s_len;i++)
        {
            record[s.charAt(i)-'a']++;
        }
        for(int j=0;j<t_len;j++)
        {
            record[t.charAt(j)-'a']--;
        }
        for(int cnt:record)
        {
            if(cnt!=0)
                return false;
        }
        return true;
    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        String s = "a";
        String t = "ab";
        boolean res = isAnagram(s, t);
        System.out.println(res);

    }
}
