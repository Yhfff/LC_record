package Competition.Week326;

/**
 *  将字符串分割成值不超过 K 的子字符串
 */

public class LC_2522 {
    public static int minimumPartition(String s, int k) {
        int ans = 0;
        // 当前的总数
        long cur = 0;
        for(int i = 0;i < s.length();i++){
            // 当前遇到的数
            int num = s.charAt(i) - '0';
            if(num > k) return -1;
            else {
                cur = cur * 10 + num;
                if(cur > k){
                    ans ++;
                    cur = num;
                }
            }
        }
        return ++ans;
    }

    public static void main(String[] args) {
        String s = "165459";
        int k = 60;
        System.out.println(minimumPartition(s,k));
    }
}
