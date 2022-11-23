package DailyProblem;

import java.util.Arrays;

/**
 * 11.23 每日一题
 * 盒子中小球的最大数量
 */
public class LC_1742 {
    public int countBalls(int lowLimit, int highLimit) {
        if(lowLimit==highLimit) return 1;
        int res = 1;
        /**
         * cnt[i]统计编号为i的盒子中球的数量
         * 由于low<=high<=100000
         * 最坏的情况为99999，其各位之和为45，因此数组大小定义为50足够
         */
        int cnt[] = new int[50];

        for(int i=lowLimit;i<=highLimit;i++){
            int index = calSum(i);
            cnt[index]++;
        }
        return Arrays.stream(cnt).max().getAsInt();
    }

    //计算一个数各位之和
    public static int calSum(int num)
    {
        int ans = 0;
        while(num>0)
        {
            ans += num%10;
            num /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(calSum(99999));
    }

}
