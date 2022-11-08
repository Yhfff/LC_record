package Other;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args)
    {
//        System.out.println(0%3);
//        // write your code here
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        //Object[] objects = list.toArray();
//        Integer[] integers = list.toArray(new Integer[0]);
//        int[] ints = list.stream().mapToInt(Integer::intValue).toArray();
//        for (Integer a: ints)
//        {
//            System.out.println(a);
//        }
        char[] a = {'1','2','3','4'};
        System.out.println(--a[1]);
    }

    public static String getType(Object o) {
        return o.getClass().getName();
    }
}
