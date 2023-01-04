package Offer;

/**
 * Offer_46 把数字翻译成字符串
 * 有条件的
 */
public class Offer_46 {
    // 由于只与前两位有关，因此不需要定义数组 定义两个变量即可 类似于斐波那契 爬楼梯
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int a = 1, b = 1;
        for(int i = 2;i <= str.length();i++){
            String tmp = str.substring(i - 2,i);
            //String.compareTo()
            int c = (tmp.compareTo("10") >= 0 && tmp.compareTo("25") <=0) ? a + b : b;
            a = b;
            b = c;
        }
        return b;
    }

    public int translateNum2(int num) {
        String str = String.valueOf(num);
        int len = str.length();
        int dp[] = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i <= len;i++){
//            String tmp = str.substring(i-2,i);
//            int cur = Integer.valueOf(tmp);
            int cur = (str.charAt(i-2) - '0') * 10 + (str.charAt(i-1) - '0');
            if(cur >= 10 && cur <= 25)
                dp[i] = dp[i-1] + dp[i-2];
            else
                dp[i] = dp[i-1];
        }
        return dp[len];
    }


}
