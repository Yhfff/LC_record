package DailyProblem;

/**
 * 10.20每日一题
 * 第K个语法符号
 */
public class LC_779 {
    public static void main(String[] args) {
        int n = 2;
        int k = 2;
        System.out.println(kthGrammar(n,k));
    }


    /**
     * 尝试找规律
     * 0
     * 0101
     * 01100110
     * 0110100101101001
     * 我们可以注意到规律：每一行的前半部分和上一行相同 每一行的后半部分正好为前半部分的“翻转”
     * 进行翻转可以选择与1异或
     * 本题有递归的思想
     */
    public static int kthGrammar(int n, int k) {
        if(n==1) return 0;
        if(k<= 1<<(n-2)){   //说明k在第n行的左半部分 与n-1行相同   <<为左移
            return kthGrammar(n-1,k);  //递归
        }
        return kthGrammar(n-1,k-(1<<n-2)) ^ 1; //后半部分 将n-1行前半部分进行翻转 使用与1异或
    }


    //返回第n行第k个字符
    public static int kthGrammar2(int n, int k) {
        String str[] = new String[n+1];
        str[1] = "0";
        for(int i=2;i<=n;i++){
            StringBuilder temp = new StringBuilder();
            String pre = str[i-1];
            //因为字符串长度是指数级增加 因此如果遍历前一个str构造新str则会超时
            for(int j=0;j<pre.length();j++){
                if(pre.charAt(j)=='0'){
                    temp.append("01");
                }else
                    temp.append("10");
            }
            str[i] = temp.toString();
        }

        return str[n].charAt(k-1)-'0';
    }
}
