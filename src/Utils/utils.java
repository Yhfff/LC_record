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
    //3. 统计字符串中指定字符的个数 比如'0' 不用for循环
    String str = "000111";
    int charNum = str.length() - str.replace("0","").length();
    //4.
}
