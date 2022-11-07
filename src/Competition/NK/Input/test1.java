package Competition.NK.Input;

import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        //System.out.println(t);
        /**
         *  nextLine会把上一个nextInt的enter键读取
         *  因此如果不加这一句 后面只会读取3行
         */
        in.nextLine(); //很关键 去读取那个enter键
        char[][] map = new char[4][4];
        while(t-->0){//可以用while 也可以用for循环 循环t次
            for(int i=0;i<4;i++){
                String str = in.nextLine();
                map[i] = str.toCharArray();
            }


        }
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.printf("%-2c",map[i][j]);
            }
            System.out.println();
        }

    }


}
