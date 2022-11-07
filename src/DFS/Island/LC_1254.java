package DFS.Island;

/**
 * 封闭岛屿的数量
 * 与LC_200岛屿数量作比较
 */

public class LC_1254 {

    /**
     * 把LC_200中那些靠边的岛屿排除掉，剩下的就是「封闭岛屿」
     * 这一题 0表示陆地 1表示海洋
     */
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        //先把靠边的岛屿给淹掉
        for(int j=0;j<n;j++){
            //dfs其实是一个淹岛屿操作
            //上
            dfs(grid,0,j);
            //下
            dfs(grid,m-1,j);
        }

        for(int i=0;i<m;i++){
            //左
            dfs(grid,i,0);
            //右
            dfs(grid,i,n-1);
        }


        //正式开始计算封闭岛屿
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 0){
                    res ++;
                    dfs(grid,i,j);
                }
            }
        }

        return res;
    }

    public void dfs(int[][] grid,int i,int j){
        int m = grid.length;
        int n = grid[0].length;

        if(i<0 || i>=m || j<0 || j>=n)
            return;
        if(grid[i][j] == 1) {
            //已经是海水了
            return;
        }

        grid[i][j] = 1;
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }



}
