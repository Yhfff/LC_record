package DailyProblem.December;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 12.19 每日一题
 * 寻找图中是否存在路径
 */
public class LC_1971_19 {
    // 深度优先搜索
    public boolean visited[];
    public List<Integer> graph[];

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        visited = new boolean[n];//[0,n-1]
        graph = new List[n];
        for(int i = 0;i < n;i++)
            graph[i] = new ArrayList<>();
        for(int []edge : edges){
            int s = edge[0], d = edge[1];
            graph[s].add(d);
            graph[d].add(s);
        }
        return dfs(source, destination);
    }

    public boolean dfs(int source, int destination){
        if(source == destination) return true;
        visited[source] = true;
        for(int d : graph[source]){
            if(!visited[d] && dfs(d, destination))
                return true;
        }
        return false;
    }
}
