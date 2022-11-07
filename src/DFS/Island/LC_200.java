package DFS.Island;

/**
 * 岛屿数量
 * 经典dfs题目 可套模板
 */
public class LC_200 {
    //方向数组 对应上下左右
    int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //boolean visited[][] = new boolean[m][n];
        int res = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]=='1'){
                    //每发现一个岛屿 res++
                    res++;
                    //使用dfs将岛屿周围淹没 即将'1'改为'0' 这样可以避免使用visited 但这样是修改了原数组
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int i,int j)
    {
        int m = grid.length, n = grid[0].length;
        //超边界
        if(i>=m || i<0 || j>=n || j<0)
            return;

        if(grid[i][j]=='0') //此点已经被淹了
            return;

        //访问当前点
        grid[i][j] = '0';
        //dfs遍历当前点的上下左右
        for(int[] dir:directions){
            int next_i = i + dir[0];
            int next_j = j + dir[1];
            dfs(grid,next_i,next_j);
        }
    }


}
