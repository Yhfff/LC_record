package TwoPointer;

//螺旋矩阵2
//不涉及什么算法 其实就是模拟过程
public class LC_59
{
    public static int[][] generateMatrix(int n)
    {
        int ans[][] = new int[n][n];
        int row = 0;
        int col = 0;
        int count = 1;
        int offset = 1;//定义偏移量
        // 模拟转圈过程 转n/2圈  右->下->左->右
        //统一每条边处理左闭右开
        for(int k=1;k<=n/2;k++)
        {
            //往右模拟
            for(;col<n-offset;col++)
                ans[row][col] = count++;
            //往下模拟 此时col=n-offset
            for(;row<n-offset;row++)
                ans[row][col] = count++;
            //往左模拟 此时row=n-offset col=n-offset
            for(;col>=offset;col--)
                ans[row][col] = count++;
            //往上模拟 此时row=n-offset col=0
            //边界是offset 不是简单的0
            for(;row>=offset;row--)
            {
//                System.out.println("row="+row);
//                System.out.println("col="+col);
//                System.out.println("count="+count);
                ans[row][col] = count++;
            }

            //一圈模拟结束后 row=0 col=0
//            System.out.println("row="+row);
//            System.out.println("col="+col);
//            System.out.println("count="+count);
            row += 1;
            col += 1;
            offset += 1;
        }
        if(n%2==1) ans[row][col] = count;
        return ans;
    }

    public static void main(String[] args)
    {
        int n = 5;
        int ans[][] = new int[n][n];
        ans = generateMatrix(n);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
                System.out.println(ans[i][j]);
            System.out.println("----------------------");
        }

    }
}
