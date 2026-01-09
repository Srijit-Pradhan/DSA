package if_else;

import java.util.Scanner;

@SuppressWarnings("resource")

public class oddeven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n % 2 == 0)
            System.out.println("even");
        else
            System.out.println("odd");

    }
}
