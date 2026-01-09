package if_else;

import java.util.Scanner;
@SuppressWarnings("resource")

public class divisibleby5ornot {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        if (n%5==0) System.out.println("divisible by 5");
        else System.out.println("not divisible");
    }
}
