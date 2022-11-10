package DP.CompleteBag;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词拆分
 *
 */
public class LC_139 {

    public static void main(String[] args) {
        String s = "123456";
        System.out.println(s.substring(2,5));
    }

    //动态规划
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        //定义set，方便后面查询某个子串是否在字典里出现过
        Set<String> set = new HashSet<>(wordDict);

        boolean dp[] = new boolean[len+1];
        dp[0] = true;

        //先遍历背包 后遍历物品
        //要求子串，最好是遍历背包放在外循环，将遍历物品放在内循环
        for(int i=1;i<=len;i++){
            for(int j=0;j<wordDict.size();j++){
                int wordLen = wordDict.get(i).length();
                if(i>=wordLen && dp[i-wordLen] && set.contains(s.substring(i-wordLen,i))){
                    dp[i] = true;
                    break; //可以加个break
                }
            }
        }

        return dp[len];
//        for(int i=0;i<wordDict.size();i++){
//            int wordLen = wordDict.get(i).length();
//            for(int j=1;j<=len;j++){
//                if(j>=wordLen && dp[j-wordLen]==true && set.contains(s.substring(j-wordLen,j)) ){
//                    //dp[j]是true，不仅要dp[j-length]为true,而且[j-length,j]的子串一定要在字典里
//                    dp[j] = true;
//                }
//            }
//        }
    }

    /**
     * 回溯
     * 与LC_131 分割回文子串类似
     * 分割s 判断子串是否包含于wordDict
     */
    public boolean wordBreak2(String s, List<String> wordDict){
        //可参考LC_131
        return true;
    }
}
