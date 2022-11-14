package Greedy;

import java.util.Arrays;

//根据身高重建队列
public class LC_406_tag {
    public static void main(String[] args) {
        int a[][] = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
//        for(int i=0;i<a.length;i++){
//            for(int j=0;j<a[0].length;j++){
//                System.out.printf("%-2d",a[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println("----------------------");
        //仅按第一列元素升序排序
        //Arrays.sort(a, (e1, e2) -> (e1[0] - e2[0]));
        // 先按第一列元素升序排序，如果第一列相等再按第二列元素升序；
        Arrays.sort(a, (e1,e2)->(e1[0]==e2[0]?(e1[1]-e2[1]):(e1[0]-e2[0])));
        int res[][] = reconstructQueue(a);
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                System.out.printf("%-2d",a[i][j]);
            }
            System.out.println();
        }

    }


    /**
     *  优先固定最矮身高的位置
     */
    public static int[][] reconstructQueue(int[][] people) {
        int row = people.length;
      //  int col = people[0].length;
        if(row==1) return people;
        int res[][] = new int[row][2];
        boolean visited[] = new boolean[row];

        // 先按第一列元素升序排序，如果第一列相等再按第二列元素升序；  lambda表达式
        Arrays.sort(people, (e1,e2)->(e1[0]==e2[0]?(e1[1]-e2[1]):(e1[0]-e2[0])));
        for(int i=0;i<row;i++){  //依次按照由矮身高到高身高处理   即优先固定矮身高的位置
            int index = people[i][1]; //前面需要几个人比他高
            for(int j=index;j<row;j++){
                if(visited[j]==false) {
                    res[j] = people[i];
                    visited[j] = true;
                    break;
                }
            }
//            while(index<row && visited[index]==false){
//                res[index] = people[i];
//                visited[index] = true;
//            }
        }
        return res;

    }
}
