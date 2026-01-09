package if_else;

import java.util.Scanner;
@SuppressWarnings("resource")

public class realnointegerornot {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("enter no: ");
        double n=sc.nextDouble();
        int x=(int)n;
        if (n-x==0) {
            System.out.println("integer");
        }
        else{
            System.out.println("not integer");
        }

    }
}
