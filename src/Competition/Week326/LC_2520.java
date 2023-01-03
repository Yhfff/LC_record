package Competition.Week326;

public class LC_2520 {
    public static int countDigits(int num) {
        int cnt = 0;
        int flag = num;
        while(num > 0){
            int tmp = num % 10;
            if(flag % tmp == 0)
                cnt ++;
            num = num/10;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int num = 121;
        System.out.println(countDigits(num));
    }
}
