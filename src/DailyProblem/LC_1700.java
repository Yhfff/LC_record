package DailyProblem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 10.19每日一题
 * 无法吃午餐的学生数量
 */
public class LC_1700 {
    public static void main(String[] args) {
        int []students = {1,1,1,0,0,1};
        int []sandwiches = {1,0,0,0,1,1};
        System.out.println(countStudents(students,sandwiches));
    }

    /**
     * 学生在队列中的顺序其实不影响 只要学生中有人要吃sandwiches中的首个元素 就一定会轮到他
     * 三明治的顺序是不变的
     * 因此
     * 1. 统计student喜欢三明治的类型
     * 2. 遍历sandwiches即可
     */
    public static int countStudents(int[] students, int[] sandwiches){
        /**
         * 统计0 1的数量 也可用一个数组
         * int[] cnt = new int[2];
         * for (int v : students) ++cnt[v];
         */
        int len = sandwiches.length;
        int num1 = Arrays.stream(students).sum(); //求student中喜欢吃1的数量
        int num0 = len - num1; //student中喜欢吃0的数量
        for(int i=0;i<len;i++){
            if(sandwiches[i]==1 && num1>0){
                num1--;
            }else if(sandwiches[i]==0 && num0>0){
                num0--;
            }else break;
        }
        return num0+num1;

    }



    //极傻做法
    public static int countStudents2(int[] students, int[] sandwiches) {
        Queue<Integer> sandQueue = new LinkedList<>(); //存储三明治
        Queue<Integer> stuQueue = new LinkedList<>();  //存储学生

        for(int i=0;i<sandwiches.length;i++){
            sandQueue.add(sandwiches[i]);
            stuQueue.add(students[i]);
        }

        while(!sandQueue.isEmpty() || !stuQueue.isEmpty()){
            int sandwich = sandQueue.peek();
            boolean flag = false;
            for(int num:stuQueue){
                if(num==sandwich){
                    flag = true;
                    break;
                }
            }
            /**
             * 说明sandQueue剩余的元素都不等于队首的元素
             * 最后sandQueue中剩余几个元素 就表示有几个学生没有吃到
             */
            if(!flag) return stuQueue.size();
            // int a = stuQueue.peek();
            if(stuQueue.peek() == sandwich){  //如果首位相等 则表示此学生可以吃到
                stuQueue.poll();
                sandQueue.poll();
            }else {
                stuQueue.add(stuQueue.poll());  //将stuQueue中首位拿出 加入末位
            }
        }
        return 0;  //说明所有学生能全部吃到
    }


}
