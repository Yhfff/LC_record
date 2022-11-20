package BackTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * b站上看到有人面试遇到这题
 */
public class LC_22 {
    static List<String> res = new ArrayList<>();
    static char[] option = {'(',')'};
    static int[] cnt = new int[2];
    public static List<String> generateParenthesis(int n) {
        backTrack(n);
        return res;
    }

    static StringBuilder sb = new StringBuilder();
    /**
     * 1. 右括号的数目>左括号的数目 剪枝
     * 2. 参数(n,左括号的数目left,右括号的数目right)
     */

    public static void backTrack(int n){
        if(cnt[1]>cnt[0]) return;
        //需要加这一句判断 否则栈溢出
        if(cnt[0]>n || cnt[0]>n) return;
        if(cnt[0]==n && cnt[0]==cnt[1]){
            res.add(sb.toString());
            return;
        }

        //有两个选择 ( )
        for(int i=0;i<2;i++){
            sb.append(option[i]);
            cnt[i]++;
            backTrack(n);
            cnt[i]--;
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        res = generateParenthesis(n);
        for(int i=0;i<res.size();i++)
            System.out.println(res.get(i));
    }
}
