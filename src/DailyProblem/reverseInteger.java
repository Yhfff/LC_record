package DailyProblem;

//Leetcode_7 整数反转
public class reverseInteger
{
    public static int reverse(int x)
    {
        //判断x的正负
        /*
        其实可以不用判断x的正负 在之后的while条件改成while(x!=0)
            if(ans>(Integer.MAX_VALUE/10) || ans<-Integer.MAX_VALUE/10) return 0;
         */
        boolean isNeg = (x<0)?true:false;
        if(isNeg)
            x = Math.abs(x); //如果为负 转变为正 最后加上负号就好
        int ans = 0;
        //List<Integer> list = new ArrayList<>();
        while (x>0)
        {
            int tmp = x%10;
            if(ans>(Integer.MAX_VALUE/10)) return 0;  //最关键的溢出判断 需要提前判断
            ans = ans*10 + tmp; //无需使用数组或者链表 直接使用不断*10
            x = x/10;
        }
//        int size = list.size() - 1;
//        for(int i=0;i<list.size();i++)
//        {
//            ans += list.get(i)*Math.pow(10,size);
//            size--;
//        }
        //if(ans>Integer.MAX_VALUE) return 0;
        if(isNeg) ans = 0-ans;
        //如果超过区间 输出0  不能简单判断
        //if(ans>Math.pow(2,31)-1 || ans<-Math.pow(2,31)) return 0;
        return ans;
    }

    public static void main(String[] args)
    {
        int x = -21383917;
        int ans = reverse(x);
        System.out.println(ans);
        System.out.println(Integer.MAX_VALUE);
    }
}
