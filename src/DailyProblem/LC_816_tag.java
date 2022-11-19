package DailyProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * 11.7 每日一题
 * 模糊坐标
 */
public class LC_816_tag {

    static List<String> res = new ArrayList<>();
    static StringBuilder path = new StringBuilder();

    //回溯
    public static List<String> ambiguousCoordinates(String s) {
        path.append("(");
        return res;
    }

    /**
     * ,后面有空格
     */
    public static void backtrack(String s,int curIndex,int len){

        //到达末尾 加个')'
        if(curIndex==len){
            path.append(")");
            res.add(path.toString());
        }

        char chr = s.charAt(curIndex);



    }

    public static boolean isValid(String path){
        return false;
    }



}
