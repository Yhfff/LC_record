package Competition.NK.E105;

import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n%16==0)
            System.out.println(5);
        else System.out.println(-1);;
    }
}
