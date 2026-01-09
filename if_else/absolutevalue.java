package if_else;

import java.util.Scanner;

@SuppressWarnings("resource")

public class absolutevalue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        if (n < 0)
            n=-n;
        System.out.println(n);
    }
}
