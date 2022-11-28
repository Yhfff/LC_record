package Competition.Week321;

/**
 * 追加字符以获得子序列
 * LC_2486
 */
public class LC_2486 {
    //通过向s末尾追加字符的方式使t变成s的一个子序列
    public int appendCharacters(String s, String t) {
        int lenS = s.length(), lenT = t.length();
        int i=0,j=0;
        int cnt = 0;
        while (i<lenS && j<lenT){
            if(s.charAt(i)==t.charAt(j)){
                cnt++;
                //只有在s中找到了t.chatAt(j) j才++ 即头开始匹配t
                j++;
            }
            i++;
        }
        return lenT-cnt;
    }
}
