package DailyProblem.December;

import java.util.Arrays;

/**
 * 12.16 每日一题
 * 构成特定和需要添加的最少元素
 */
public class LC_1785_16 {
    public int minElements(int[] nums, int limit, int goal) {
        //long sum = Arrays.stream(nums).sum();
        long sum = Arrays.stream(nums).asLongStream().sum();
        long diff = Math.abs(sum - goal);
        //if(diff == 0) return 0;
        //return (int) Math.ceil((double)diff/limit);
        return (int) ((diff + limit -1) / limit);
    }



    public static void main(String[] args) {

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Math.ceil((double)5/3));

    }
}
