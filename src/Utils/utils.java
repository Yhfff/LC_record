package Utils;

import java.util.Arrays;

public class utils {
    int num[] = {1,2,3,4,5};
    //1. 使用流的方式求数组和
    int sum = Arrays.stream(num).sum();
    //2. 辗转相除法求最大公约数
    public static int gcd(int m,int n){
        int res = 0;
        while(n!=0){
            res = m % n;
            m = n;
            n = res;
        }
        return m;
    }
    //递归
    public static int gcd2(int a,int b){
//        if(b==0) return a;
//        return gcd(b,a%b);
        return b==0?a:gcd2(b,a%b);
    }
    //3. 统计字符串中指定字符的个数 比如'0' 不用for循环
    String str = "000111";
    int charNum = str.length() - str.replace("0","").length();
    //4. 使得两个整型相除保留小数位
    int len = 8;
    int Sum = 36;
    /**
     * 1. 将被除数转为float或者double
     * 2. 将除数转为float或者double
     */
    float avg = (float)Sum/len;



}
