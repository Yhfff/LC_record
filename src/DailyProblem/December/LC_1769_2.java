package DailyProblem.December;

import org.omg.CORBA.MARSHAL;

import java.util.ArrayList;
import java.util.List;

/**
 * 12.2 每日一题
 * 移动所有球到每个盒子所需的最小操作数
 */
public class LC_1769_2 {
    //双重循环O(N)
    public static int[] minOperations(String boxes) {
        int len = boxes.length();
        int ans[] = new int[len];
        //int index[] = new int[len];
        List<Integer> list = new ArrayList<>();
        int j=0;
        for(int i=0;i<len;i++){
            if (boxes.charAt(i)=='1'){
                list.add(i);
            }
        }

        for(int i=0;i<len;i++){
            int tmp = 0;
            for(int k=0;k<list.size();k++){
                tmp += Math.abs(i - list.get(k));
            }
            ans[i] = tmp;
        }


        return ans;
    }

    //根据前一个盒子的操作数 统计下一个盒子  有点像动态规划
    public static int[] minOperations2(String boxes){
        int operation = 0, left = 0;
        int right = 0;
        int len = boxes.length();
        int ans[] = new int[len];


        for(int i=1;i<len;i++){
            ans[i] = operation + left - right;


        }
        return ans;
    }


    public static void main(String[] args) {
        String boxes = "001011";
        int ans[] = minOperations(boxes);
        for(int x:ans)
            System.out.println(x);
    }
}
