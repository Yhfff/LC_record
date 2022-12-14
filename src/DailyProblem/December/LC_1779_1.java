package DailyProblem.December;

/**
 * 12.1 每日一题
 * 找到最近的有相同 X 或 Y 坐标的点
 */
public class LC_1779_1 {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int min = Integer.MAX_VALUE;
        int ans = -1;
        for(int i = 0;i < points.length;i++){
            int curX = points[i][0];
            int curY = points[i][1];
            if(x == curX || y == curY){
                int dis = Math.abs(x - curX) + Math.abs(y - curY);
                if( dis < min){
                    min = Math.min(min, dis);
                    ans = i;
                }

            }
        }
        return ans;
    }
}
