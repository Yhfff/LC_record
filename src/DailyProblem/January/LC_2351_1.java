package DailyProblem.January;

/**
 * 1.1 每日一题
 * 第一个出现两次的字母
 */
public class LC_2351_1 {
    // 哈希表 数组
    public char repeatedCharacter(String s) {
         int cnt[] = new int[26];
         for(char chr : s.toCharArray()){
             if(++cnt[chr - 'a'] == 2)
                 return chr;
         }
        return 'a';
    }

    // 位运算 代替数组
    public char repeatedCharacter2(String s) {
        int mask = 0;
        for(char chr : s.toCharArray()){
            int tmp = 1 << (chr - 'a');
            if((mask & tmp) != 0) return chr;
            mask |= tmp;
        }
        return 'a';
    }

}
