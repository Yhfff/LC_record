package DailyProblem.December;

import java.util.NavigableMap;

/**
 * 12.12 每日一题
 * 所有子字符串美丽值之和
 */
public class LC_1781_12 {
    public int beautySum(String s) {
        int len = s.length();
        int ans = 0;
        //开始位置
        for(int i=0;i<len;i++){
            int cnt[] = new int[26];
            //终止位置
            for(int j=i;j<len;j++){
                cnt[s.charAt(j)-'a']++;
                int maxFreq = -1;
                int minFreq = 501;
                for(int k=0;k<26;k++){
                    if(cnt[k] > 0){
                        maxFreq = Math.max(maxFreq, cnt[k]);
                        minFreq = Math.min(minFreq, cnt[k]);
                    }
                }
                ans += maxFreq - minFreq;
            }
        }
        return ans;
    }
}
