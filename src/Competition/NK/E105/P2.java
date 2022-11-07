package Competition.NK.E105;


import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int MOD = 1000000007;
        int n = in.nextInt();//n为新生的数量
        int num = n/2;//偶数的数量
        int negNum = n - num;//奇数的数量
        int res = num*(cal(n-1,MOD)-cal(negNum,MOD));
        System.out.println(res); //在牛客中直接System.out.println()
    }

    public static int cal(int n,int MOD){
        int res = 1;
        for(int i=1;i<=n;i++){
            res *= i;
            res %= MOD;
        }
        return res;
    }


    //辗转相除法求最大公约数
    public static int gcd(int m,int n){
        int res = 0;
        while(n!=0){
            res = m % n;
            m = n;
            n = res;
        }
        return m;
    }

}
