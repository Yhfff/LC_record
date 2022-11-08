package Greedy;

//单调递增的数字
public class LC_738 {
    public static void main(String[] args) {
        int n = 332;
        System.out.println(monotoneIncreasingDigits(n));
        isMonotoneIncreasing(n);

    }


    //贪心  举例 98——》(9-1)9 -> 89
    public static int monotoneIncreasingDigits(int n) {
        String str = String.valueOf(n);
        char chr[] = str.toCharArray();

        int flag = chr.length;//记录从哪里开始需要赋9  一定要初始化为chr.length
        //从后往前遍历
        for(int i=chr.length-2;i>=0;i--){
            if(chr[i] > chr[i+1]){
                chr[i]--;  //虽然是char 但是可以直接--
                flag = i+1;
            }
        }

        for(int i=flag;i<chr.length;i++)
            chr[i] = '9';
        return Integer.valueOf(String.valueOf(chr));
    }

    //暴力
    public static int monotoneIncreasingDigits2(int n) {
        for(int start = n;start>0;start--){
            if(isMonotoneIncreasing(start)){
                return start;
            }
        }
        return 0;
    }

    public static boolean isMonotoneIncreasing(int n){
       // int flag = Integer.MAX_VALUE; //其实不需要定义为Integer.MAX_VALUE 定义为10就行
        int flag = 10;
        int temp;
        while(n>0){
            temp = n%10;
            //System.out.println(temp);
            if(temp>flag)
                return false;
            n = n/10;
            flag = temp;
        }
        return true;
    }

}
