package DailyProblem.December;

/**
 * 12.13 每日一题
 * 判断句子是否为全字母句
 */
public class LC_1832_13 {
    public boolean checkIfPangram(String sentence) {
        boolean isExist[] = new boolean[26];
        for(int i = 0;i < sentence.length();i++){
            isExist[sentence.charAt(i)-'a'] = true;
        }
        for(boolean tmp : isExist){
            if(!tmp)
                return false;
        }
        return true;
    }

    public boolean checkIfPangram2(String sentence) {
        int mask = 0;
        for (int i = 0;i < sentence.length();i++){
            mask |= 1 << (sentence.charAt(i) - 'a' );
        }
        return mask == (1<<26 - 1);
    }
}
