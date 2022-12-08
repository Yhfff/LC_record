package DailyProblem.December;

/**
 * 12.8 每日一题
 * 判断国际象棋棋盘中一个格子的颜色
 */
public class LC_1812_8 {
    public boolean squareIsWhite(String coordinates) {
        int x = coordinates.charAt(0) - 'a';
        int y = coordinates.charAt(1) - '0';
        /**
         * 这么判断的话 其实可以简化
         * 1. x + y为偶数时 return true  为奇数时 return false
         * 2. 异或
         */
        if(x%2 == 0 && y%2 == 0) return true; //奇 + 奇
        if(x%2 != 0 && y%2 != 0) return true; //偶 + 偶
        if(x%2 == 0 && y%2 != 0) return false;//偶 + 奇
        if(x%2 != 0 && y%2 == 0) return false;//奇 + 偶
        return true;
    }

    public static void main(String[] args) {
        // 两个字符相加  -》  ASCII码直接相加
        System.out.println('a' + '1');
    }
}
