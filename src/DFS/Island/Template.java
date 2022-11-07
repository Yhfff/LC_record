package DFS.Island;

//岛屿问题模板
public class Template {
    //方向数组 对应上下左右
    int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

    public void dfs(char[][] grid, int i,int j,boolean[][] visited)
    {
        int m = grid.length, n = grid[0].length;
        //超边界
        if(i>m || i<0 || j>n || j<0)
            return;

        if(visited[i][j]) //此点已经被访问
            return;

        //访问当前点
        visited[i][j] = true;
        //dfs遍历当前点的上下左右
        for(int[] dir:directions){
            int next_i = i + dir[0];
            int next_j = j + dir[1];
            dfs(grid,next_i,next_j,visited);
        }

        //另一种写法
        dfs(grid,i-1,j,visited);//上
        dfs(grid,i+1,j,visited);//下
        dfs(grid,i,j-1,visited);//左
        dfs(grid,i,j+1,visited);//右
    }
}
