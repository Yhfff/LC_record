package Greedy;

//加油站
public class LC_134 {
    public static void main(String[] args) {
        int gas[] = {1,2,3,4,5};
        int cost[] = {3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas,cost));
    }

    /**
     *贪心：如果总油量减去总消耗大于等于零那么一定可以跑完一圈
     *     说明各个站点的加油站 剩油量rest[i]相加一定是大于等于零的
     *     i从0开始累加rest[i]，和记为curSum，一旦curSum小于零，说明[0, i]区间都不能作为起始位置，
     *     起始位置从i+1算起，再从0计算curSum
     */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0; //总的剩油量
        int res = 0;//起点坐标
        int cur = 0; //当前剩油量
        
        for(int i=0;i<gas.length;i++)
        {
            cur += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if(cur<0){
                res = i+1;  //此点一定不可以用作起点 设为i+1
                cur = 0;
            }
        }
        if(total<0) return -1;
        return res;
    }


    /**
     *暴力：遍历每一个加油站为起点的情况，模拟一圈
     *     如果跑了一圈，中途没有断油，而且最后油量大于等于0，说明这个起点是ok的
     */
    public static int canCompleteCircuit2(int[] gas, int[] cost) {
        int len = gas.length;
        for(int i=0;i<len;i++) //使用for循环进行一个起点一个起点的模拟
        {
            int remain = gas[i] - cost[i];
            int index = (i + 1) % len; //下一个加油站索引
            while (remain >= 0 && index != i) // 使用while模拟以i起点 行驶一圈
                                              // remain>=0表示不能断油 不能省略 一定要判断的
            {
                remain += gas[index] - cost[index];
                index = (index + 1) % len;  //再下一个
            }
            if (remain >= 0 && index == i) return i;
        }
        return -1;
    }



}
