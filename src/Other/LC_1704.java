package Other;

import javax.swing.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 11.11 每日一题
 * 判断字符串的两半是否相似
 */
public class LC_1704 {
    public static void main(String[] args) {
        System.out.println(halvesAreAlike("book"));
    }

    /**
     * 2. 定义s = "aeiouAEIOU"
     *    string.indexof()>=0 判断字符是否出现  string.contains()
     *
     * 3. 后续计数的时候，其实只需要定义一个变量num
     *    遍历前半段让num++ 后半段让num--
     *    最后判断num==0
     */
    public static boolean halvesAreAlike(String s) {
        Character letters[] = {'a','e','i','o','u','A','E','I','O','U'};
        // List<char[]> list = Arrays.asList(letters);
        // Arrays.asList() 传入的数组一定要是对象数组 而不是基本类型数组
        Set<Character> letter= new HashSet<>( Arrays.asList(letters));
        for (char x:
             letter) {
            System.out.println(x);
        }
//        letters.add('a');
//        letters.add('e');
//        letters.add('i');
//        letters.add('o');
//        letters.add('u');
        int len = s.length();
        s = s.toLowerCase();
        int num1 = 0, num2 = 0;
        for(int i=0;i<len;i++){
            char chr = s.charAt(i);
            if(i<len/2){
                if(letter.contains(chr))
                    num1++;
            }else{
                if(letter.contains(chr))
                    num2++;
            }
        }

        return num1==num2;
    }
}
