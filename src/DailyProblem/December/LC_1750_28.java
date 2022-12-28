package DailyProblem.December;

/**
 * 12.28 每日一题
 * 删除字符串两端相同字符后的最短长度
 */
public class LC_1750_28 {
    public static int minimumLength(String s) {
        int len = s.length();
        int i = 0, j = len - 1;
        //i=j跳出循环，因为就只有一个元素
        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
                while(i <= j && s.charAt(i) == s.charAt(i-1)){
                    i++;
                }
                while(i <= j && s.charAt(j) == s.charAt(j+1)){
                    j--;
                }
            }else
                break;
        }
        return j - i + 1;
    }

    public static void main(String[] args) {
        String s = "abbbbbbbbbbbbbbbbbbba";
        System.out.println(minimumLength(s));
    }
}
