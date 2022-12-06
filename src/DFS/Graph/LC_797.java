package DFS.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * dfs 图
 * 所有可能的路径
 */
public class LC_797 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        path.add(0);//不管怎样都是要从0节点出发
        dfs(graph,0);
        return res;
    }

    public void dfs(int [][]graph, int curNode){
        //到达 n -1 节点
        if(curNode == graph.length - 1){
            //找到符合的路径
            res.add(new ArrayList<>(path));
            return;
        }

        //遍历每一个节点连接的节点 回溯
        for(int i = 0;i < graph[curNode].length;i++){
            path.add(graph[curNode][i]);
            dfs(graph,graph[curNode][i]);
            path.remove(path.size()-1);
        }
    }
}
