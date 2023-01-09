package DailyProblem.January;

/**
 * 1.9 每日一题
 * 还原排列的最小操作步数
 */
public class LC_1806_9 {
    public int reinitializePermutation(int n) {
        int ans = 0;
        // 只有有一个元素回到了原来位置 序列就会和之前一致 以下标为1的元素举例
        int index = 1;
        /**
         * while()条件里 ans == 0是为了防止第一次while无法进入
         * 或者可以使用do{}while()
         */
        while(ans == 0 || index != 1){
            ans++;
            // 注意运算符优先级
            if(index < (n >> 1)){
                // 下标扩大两倍
                index <<= 1;
            }else {
                // index = 2 * index - n + 1
                index = (index << 1) - n + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(6 >> 1);
    }
}
