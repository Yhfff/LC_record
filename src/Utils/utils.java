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
        if(b==0) return a;
        return gcd(b,a%b);
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
    //5. 二维数组排序
    public static void main(String[] args) {
        int a[][] = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        //仅按第一列元素升序排序
        //Arrays.sort(a, (e1, e2) -> (e1[0] - e2[0]));
        // 先按第一列元素升序排序，如果第一列相等再按第二列元素升序；
        Arrays.sort(a, (e1,e2)->(e1[0]==e2[0]?(e1[1]-e2[1]):(e1[0]-e2[0])));
    }

}
