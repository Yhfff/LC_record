package Competition.DoubleWeek.Week94;
/**
 * 第一题
 * 最多可以摧毁的敌人城堡数目
 */
public class LC_2511 {
    public int captureForts(int[] forts) {
        int ans = 0;
        //1和-1连续0的个数
        int pos = -1, neg = -1;
        boolean isPos = false, isNeg = false;
        for(int i = 0;i < forts.length;i++){
            if(forts[i] == 1){
                pos = i;
                isPos = true;
            }else if(forts[i] == -1){
                neg = i;
                isNeg = true;
            }
            if(isPos && isNeg){
                ans = Math.max(ans, Math.abs(pos - neg) - 1);
                if(forts[i] == 1)
                    isNeg = false;
                else  if(forts[i] == -1)
                    isPos = false;
            }
        }
        return ans;
    }
}
