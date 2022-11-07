package HashTable;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_202
{
    public static boolean isHappy(int n)
    {
        Set<Integer> sum = new HashSet<>();
        int ans = getSum(n);
        while(ans!=1 && !sum.contains(ans))
        {
            sum.add(ans);
            ans = getSum(ans);
        }
        return ans==1;
    }
    //求和 即每一位的平方和
    public static int getSum(int num)
    {
        int res = 0;
        while(num>0)
        {
            int temp = num % 10; //求个位
            res += temp * temp;
            num = num / 10;
        }
        return res;
    }
}
