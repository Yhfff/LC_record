package Competition.DoubleWeek.Week95;

/**
 * Week95 双周赛
 * 根据规则将箱子分类
 */
public class LC_2525 {
    public static String categorizeBox(int length, int width, int height, int mass) {
        boolean isHeavy = (mass >= 100);
        boolean isBulky = false;
        // 注意转long
        long V = (long) length * width * height;
        if((length >= 1e4 || width >= 1e4 || height >= 1e4) || V >= 1e9)
            isBulky = true;
        if(isHeavy && isBulky) return "Both";
        else if(!isHeavy && !isBulky) return "Neither";
        else if(isBulky) return "Bulky";
        else return "Heavy";
    }

    public static void main(String[] args) {
        System.out.println(2909 >= 1e4);
        System.out.println(categorizeBox(2909, 3968, 3272, 727));
    }
}