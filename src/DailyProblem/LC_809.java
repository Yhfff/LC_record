package DailyProblem;

/**
 * 11.25 每日一题
 * 情感丰富的文字
 * 双指针+模拟
 */
public class LC_809 {
    public int expressiveWords(String s, String[] words) {
        int res = 0;
        for(String word:words){
           if(judge(s,word))
               res++;
        }
        return res;
    }

    public boolean judge(String s,String word){
        int lenS = s.length();
        int lenW = word.length();
        int i = 0, j = 0;
        while(i<lenS && j<lenW){
            if(s.charAt(i) != word.charAt(j))
                return false;
            char chr = s.charAt(i);
            int cntS = 0, cntW = 0;
            while(i<lenS && s.charAt(i)==chr){
                cntS ++;
                i++;
            }
            while(j<lenW && word.charAt(j)==chr){
                cntW ++;
                j++;
            }
            //如果某个字符连续在S中出现的次数<在word中出现的次数 肯定不符合
            if(cntS<cntW) return false;
            //如果某个字符连续在S中出现的次数>在word中出现的次数 但少于3次 也不符合
            if(cntS>cntW && cntS<3) return false;
        }
        //一定要保证两个字符串都遍历至末尾
        return i==lenS && j==lenW;
    }
}
