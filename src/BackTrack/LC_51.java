package BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//困难题
//N皇后问题  -》 二维矩阵回溯
public class LC_51
{
    static List<List<String>> res = new ArrayList<>();
    public static void main(String[] args)
    {
        int n = 4;
        res = solveNQueens(n);

        char[][] chessboard = new char[n][n];

        for(List list:res)
            System.out.println(list);
    }

    public static List<List<String>> solveNQueens(int n)
    {
        char[][] chessboard = new char[n][n];
        for(int i=0;i<n;i++)
            Arrays.fill(chessboard[i],'.');  //使用Arrays.fill对二维数组一次性赋值
        backtrack(n,0,chessboard);
        return res;
    }

    public static void backtrack(int n,int row,char[][] chessboard)
    {
        //说明找到了叶子节点
        if(n==row)
        {
            //if(isValid(chessboard,n,row,0))
            res.add(Array2List(chessboard));   //将二维字符数组chessboard转化为List<String>的列表
            return;
        }

        for(int col=0;col<n;col++)
        {
            if(isValid(chessboard,n,row,col))  //满足条件再回溯
            {
                chessboard[row][col] = 'Q';
                backtrack(n,row+1,chessboard);
                chessboard[row][col] = '.'; //回溯
            }
        }
    }

    //将二维字符数组chessboard转化为List<String>的列表
    public static List Array2List(char[][] chess)
    {
        List<String> strList = new ArrayList<>();
        for(char[] temp:chess)
            strList.add(String.copyValueOf(temp)); //String.copyValueOf()可以将多个字符拼成一个字符串
        return strList;
    }

    /*
        判断棋盘是否合规
        也就是判断两个棋子是否位于同一行 同一列 同一斜线 否则就不符合
     */
    public static boolean isValid(char[][] chessboard,int n,int row,int col)
    {
        /*
        同一行
        但其实不需要检测同一行 因为每一次backtrack 同一行只会有一个元素
         */

        //同一列
        for(int i=0;i<row;i++)
        {
            if(chessboard[i][col]=='Q')
                return false;
        }

        //同一斜线 需要注意 有45度和135度两种情况
        //检查45度
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--)
        {
           if(chessboard[i][j]=='Q')
               return false;
        }

        //检查135度
        for(int i=row-1,j=col+1;i>=0 && j<n;i--,j++)
        {
            if(chessboard[i][j]=='Q')
                return false;
        }

        return true;
    }

}
