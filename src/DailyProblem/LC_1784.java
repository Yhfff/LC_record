package DailyProblem;

/**
 * 10.3每日一题
 * 检查二进制字符串片段
 */
public class LC_1784 {
    public static void main(String[] args) {
        String s = "110";
        System.out.println(checkOnesSegment(s));
    }

    public static boolean checkOnesSegment(String s) {
        int cnt = 1;
        boolean flag = false;  //true表示下一个1是一个新的连续‘1’的开始
        for(int i=1;i<s.length();i++){
            char temp = s.charAt(i);
            if(temp=='0'){
                flag = true;
            }else {
                if(flag){
                    cnt++;
                    flag = false;
                }
            }
        }
        return cnt>=2?false:true;
    }
}
