package DailyProblem.January;

/**
 * 1.8 每日一题
 * 统计包含给定前缀的字符串
 */
public class LC_2185_8 {
    public int prefixCount(String[] words, String pref) {
        int ans = 0;
        int len = pref.length();
        for(String word : words){
            if(word.length() >= len){
                int i = 0;
                while( i < len && (word.charAt(i) == pref.charAt(i))){
                    i++;
                }
                if(i == len) ans++;
            }

        }
        return ans;
    }
}
