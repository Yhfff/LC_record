package Competition.Week321;

/**
 * 92Week双周赛 P3
 */
public class LC_2483 {
    public static int bestClosingTime(String customers) {
        int len = customers.length();
        //计算i后面有几个Y 包括i
        int cntY[] = new int[len+1];
        //计算i前面有几个N  不包括i
        int cntN[] = new int[len+1];

        for(int i=len-1;i>=0;i--){
            cntY[i] = cntY[i+1] + (customers.charAt(i)=='Y' ? 1 : 0);
        }
        for(int i=0;i<len;i++){
            cntN[i+1] = cntN[i] + (customers.charAt(i)=='N' ? 1 : 0);
        }

        int min = Integer.MAX_VALUE;
        int ans = -1;
        for(int i=0;i<=len;i++){
            int tmp = cntY[i] + cntN[i];
            if(tmp < min){
                ans = i;
                min = tmp;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String d = "YYNY";
        bestClosingTime(d);

    }

}
