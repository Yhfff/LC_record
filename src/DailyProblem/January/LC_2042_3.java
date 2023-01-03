package DailyProblem.January;

/**
 * 1.3 每日一题
 * 检查句子中的数字是否递增
 */
public class LC_2042_3 {
    public static boolean areNumbersAscending(String s) {
        String[] words = s.split(" ");
        int pre = -1, cur = 0;
        for(String word : words){
            if(Character.isDigit(word.charAt(0))){
                cur = Integer.parseInt(word);
                if(cur <= pre) return false;
                else pre = cur;
            }
        }
        return true;
    }

    public static boolean areNumbersAscending2(String s) {
        String[] words = s.split(" ");
        int pre = -1, cur = 0;
        for(String word : words){
            try {
                cur = Integer.parseInt(word);
                if(cur <= pre) return false;
                else pre = cur;
            }catch (Exception e){};
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "1 box has 3 blue 4 red 6 green and 12 yellow marbles";
        System.out.println(areNumbersAscending(s));
        System.out.println(1 >> 3);
    }
}
