package DFS.Island;

/**
 * 岛屿数量
 * 经典dfs题目 可套模板
 */
public class LC_200_2 {
    //方向数组 对应上下左右
    int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean visited[][] = new boolean[m][n];
        int res = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]=='1' && !visited[i][j]){
                    //每发现一个岛屿 res++
                    res++;
                    dfs(grid,i,j,visited);
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int i,int j,boolean[][] visited)
    {
        int m = grid.length, n = grid[0].length;
        //超边界
        if(i>=m || i<0 || j>=n || j<0)
            return;

        if(grid[i][j]=='0' || visited[i][j]) //此点已经被访问
            return;

        //访问当前点 开始处理
        visited[i][j] = true;
        //dfs遍历当前点的上下左右
        for(int[] dir:directions){
            int next_i = i + dir[0];
            int next_j = j + dir[1];
            dfs(grid,next_i,next_j,visited);
        }
    }
}
