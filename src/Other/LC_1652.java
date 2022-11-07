package Other;

import java.util.Arrays;

/**
 * 每日一题 拆炸弹
 * 有改进的空间
 */
public class LC_1652 {
    public static void main(String[] args) {
        int []code = {2,4,9,3};
        int k = -2;
        int res[] = decrypt(code,k);
        for(int x:res)
            System.out.println(x);
    }

    public static int[] decrypt(int[] code, int k) {
        int len = code.length;
        int res[] = new int[len];
        if(k==0) {
            Arrays.fill(code,0);
            return code;
        }
        if(k>0){
            for(int i=0;i<len;i++){
                int temp = 0;
                for(int j=1;j<=k;j++)
                    temp += code[(i+j)%len];
                res[i] = temp;
            }
        }else {
            for(int i=0;i<len;i++){
                int temp = 0;
                //如何往前找需要的元素
                for(int j=len+k;j<len;j++)
                    temp += code[(i+j)%len];
                res[i] = temp;
            }
        }
        return res;
    }
}
