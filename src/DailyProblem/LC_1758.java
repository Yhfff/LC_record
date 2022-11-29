package DailyProblem;

/**
 * 11.29 每日一题
 * 生成交替二进制字符串的最少操作数
 */
public class LC_1758 {

    public int minOperations(String s) {
        int len = s.length();
        if(len==1) return 0;
        //cnt1记录0开头 cnt2记录1开头
        int cnt1 = 0, cnt2 = 0;
        for(int i=0;i<len;i++){
            char chr = s.charAt(i);
            //此时下标为偶数
            if(i%2==0){
                if(chr=='0') cnt1++;
                else cnt2++;
            }else { //下标为奇数
                if(chr=='0') cnt2++;
                else cnt1++;
            }
        }
        return Math.min(cnt1,cnt2);
    }
}
