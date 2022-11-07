package Other;

/**
 * 10.23每日一题
 * 交替合并字符串
 */
public class LC_1768 {

    public String mergeAlternately(String word1, String word2) {
        StringBuilder res = new StringBuilder();
        int index = 0;
        int len1 = word1.length();
        int len2 = word2.length();
        while (index<len1 && index<len2) {
            res.append(word1.charAt(index));//添加word1
            res.append(word2.charAt(index));//添加word2
            index++;
        }
        //有个字符串遍历完成 但另一个还有
        if(index<len1){
            res.append(word1.substring(index,len1));
        }else
            res.append(word2.substring(index,len2));
        return res.toString();
    }

    //由于是处理两个字符串->双指针
    public String mergeAlternately2(String word1, String word2) {
        StringBuilder res = new StringBuilder();
        int index1 = 0,index2 = 0;
        int len1 = word1.length();
        int len2 = word2.length();
        while (index1<len1 || index2<len2) {
            if(index1<len1)
            {
                res.append(word1.charAt(index1));//添加word1
                index1++;
            }
            if(index2<len2){
                res.append(word2.charAt(index2));//添加word2
                index2++;
            }
        }
        return res.toString();
    }
}
