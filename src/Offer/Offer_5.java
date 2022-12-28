package Offer;

/**
 * Offer5. 替换空格
 * Java里面字符串是不可变类型，是不可修改的
 */
public class Offer_5 {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for(char chr : s.toCharArray()){
            if(chr ==' ')
                sb.append("%20");
            else
                sb.append(chr);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("we are family".replace(" ","%20"));
    }
}
