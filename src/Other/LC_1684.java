package Other;

/**
 * 11.8每日一题
 * 统一一致字符串的数目
 */
public class LC_1684 {
    public static void main(String[] args) {
        String allowed = "ab";
        String words[] = {"ad","bd","aaab","baa","badab"};
        System.out.println(countConsistentStrings(allowed,words));

//        System.out.println(6>>3);
//
//        int mask = 0;
//        for(int i=0;i< allowed.length();i++)
//        {
//            mask = mask | 1<<(allowed.charAt(i)-'a');
//        }
//        System.out.println(mask);
    }

    /**
     *1.  更巧妙的做法是本题可以先把cnt定义为words.length
     *    一旦有不符合的 cnt--即可
     *    比定义cnt=0找到符合的再cnt++更方便
     *
     *2. 不定义映射表 使用allowed.contains(String.valueOf(chr))判断
     *
     *3. 不定义映射表 由于是26位字母 因为可以定义一个int(32位)
     *   来表示某个字符是否在allowed中出现过
     *   更省空间
     */
    public static int countConsistentStrings(String allowed, String[] words) {
        int cnt = 0;
        int table[] = new int[26];

        for(int i=0;i<allowed.length();i++){
            table[allowed.charAt(i)-'a']++;
        }

//        for(String word:words) {
//            for (char chr : word.toCharArray()) {
//                if (table[chr - 'a'] == 0) { //遇到不符合的word
//                    cnt--;
//                }
//            }
//        }

        //JAVA使用标签跳出循环
        outer:for(String word:words){
            for(char chr:word.toCharArray()){
                if(table[chr-'a']==0){
                    continue outer;
                }
            }
            cnt++;
        }



//        for(String word:words){
//            int flag = 0;  //boolean flag = true;
//            for(char chr:word.toCharArray()){
//                if(table[chr-'a']==0){
//                    break;
//                }else {
//                    flag++;
//                }
//            }
//            if(flag==word.length()) cnt++;
//        }
        return cnt;
    }


    public static int countConsistentStrings2(String allowed, String[] words) {
        int cnt = 0;
        int mask = 0;

        for(int i=0;i<allowed.length();i++){
           mask |= (1<<(allowed.charAt(i)-'a'));
        }

        for(String word:words) {
            int mask1 = 0;
            for (char chr : word.toCharArray()) {
                mask1 |= (1<<(chr-'a'));
            }
            //说明mask1为mask的子集，即word的字符在allowed都出现过
            if((mask1|mask)==mask)
                cnt++;
        }


        return cnt;

    }
}
