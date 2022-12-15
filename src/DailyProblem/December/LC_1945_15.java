package DailyProblem.December;

/**
 * 12.15 每日一题
 * 字符串转化后的各位数字之和
 */
public class LC_1945_15 {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        //转化成数字
        for(char chr : s.toCharArray()){
            sb.append(chr - 'a' + 1);
        }
        String str = sb.toString();
        int sum = 0;
        while(k>0){
            sum = 0;
            for(int i = 0;i < str.length();i++){
                sum += str.charAt(i) - '0';
            }
            str = String.valueOf(sum);
            k--;
        }
        return sum;
    }
}
