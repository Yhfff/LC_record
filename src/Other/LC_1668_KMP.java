package Other;

import javax.jws.soap.SOAPBinding;

/**
 * 11.3 每日一题
 * 最大重复子字符串
 * 需要学习KMP算法
 */
public class LC_1668_KMP {
    public static void main(String[] args) {
        String seq = "abcab";
        String word = "ab";
        // System.out.println(seq.contains(word));
        System.out.println(maxRepeating(seq,word));
    }

    /**
     * 字符串匹配  -》 KMP
     *
     * 返回word在sequence中连续重复的次数 注意是连续
     */
    //双指针？  我这样写根本没有考虑连续
    public static int maxRepeating(String sequence, String word) {
        int cnt = 0;
        int len1 = sequence.length();
        int len2 = word.length();
        int i = 0,j = 0;
        while(i<len1){
            if(sequence.charAt(i) == word.charAt(j)){
                i++;
                j++;
            }else {
                i++;
                j = 0;
            }
            if(j==len2){
                //i++;
                j = 0;
                cnt++;
            }
        }
        return cnt;
    }

    //究极暴力：String.contains()
    public static int maxRepeating2(String sequence, String word) {
        String s = word;
        int ans = 0;
        while (sequence.contains(s)){
            ans++;
            s += word;  //由于是连续重复 因此不断拼接word
        }
        return ans;
    }
}
