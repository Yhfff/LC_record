package DFS.Island;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成 其实也能用回溯
 */
public class LC_22 {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
       dfs("",n,0,0);
       return res;
    }

    public void dfs(String path,int n,int left,int right){
        if(right>left || left>n) return;
        if(left==right && left==n) {
            res.add(path);
        }
        dfs(path+'(',n,left+1,right);
        dfs(path+')',n,left, right+1);
    }

}
