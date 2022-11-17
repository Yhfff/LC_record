package TwoPointer;

/**
 * 11.17每日一题LC_792的一个子问题
 * 判断子序列
 */
public class LC_392 {
    //双指针
    //判断s是否为t的子序列
    public boolean isSubsequence(String s, String t) {
        int lenT = t.length();
        int lenS = s.length();
        if(lenS==0) return true;//""(空字符串) 肯定为true
        //i为s的指针 j为t的指针
        int i=0,j=0;
        while(i<lenS&&j<lenT){
            if(s.charAt(i)==t.charAt(j)){
                i++;
            }
            j++;
        }
        return i==lenS;
    }


    //判断s是否为t的子序列
    public boolean isSubsequence2(String s, String t) {
        //int lenT = t.length();
        int lenS = s.length();
        if(lenS==0) return true;//""(空字符串) 肯定为true
        int index = t.indexOf(s.charAt(0)) ;
        if(index<0) return false;

        for(int i=1;i<lenS;i++){
            int temp = t.substring(index+1).indexOf(s.charAt(i));
            if(temp<0)
                return false;
            index += temp+1;
        }

        return true;
    }



    public static void main(String[] args) {
        String s = "";
        System.out.println(s.indexOf('a'));
    }
}
