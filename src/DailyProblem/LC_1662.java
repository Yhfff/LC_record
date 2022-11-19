package DailyProblem;

/**
 * 11.1每日一题
 * 检查两个字符串数组是否相等
 */
public class LC_1662 {
    public static void main(String[] args) {
        String word1[] = {"ab", "c"};
        String word2[] = {"a", "cb"};
        System.out.println(arrayStringsAreEqual(word1,word2));
    }

    /**
     * 双指针 一边遍历一遍比较
     * 不额外创建其他新的空间
     */
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int len1 = word1.length;
        int len2 = word2.length;
        /**
         * m,i 控制word1  word1[m].charAt(i)
         * n,j 控制word2  word2[n].charAt(j)
         */
        int m=0,n=0,i=0,j=0;
        while(m<len1 && n<len2 ){
            char c1 = word1[m].charAt(i);
            char c2 = word2[n].charAt(j);
            if(c1!=c2) return false;
            else{
                if(i==word1[m].length()-1) {
                    m++;
                    i = 0;
                } else i++;
                if(j==word2[n].length()-1) {
                    n++;
                    j = 0;
                } else j++;
            }
        }
        return m==len1 && n==len2;
    }

    //直接拼接成字符串进行比较 空间复杂度O(n)
    public static boolean arrayStringsAreEqual2(String[] word1, String[] word2) {
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        for(int i=0;i<word1.length;i++)
            str1.append(word1[i]);
        for(int j=0;j<word2.length;j++)
            str2.append(word2[j]);
        return str1.toString().equals(str2.toString());
    }



}
