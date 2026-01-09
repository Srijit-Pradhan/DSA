package Basics;
import java.util.Scanner;
@SuppressWarnings("resource")

public class simpleinterest {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter princial: ");
        int p = sc.nextInt();
        System.out.print("Enter rate of interst: ");
        double r = sc.nextDouble();
        System.out.print("Enter time: ");
        double t = sc.nextDouble();

        double si = (p*r*t)/100;
        System.out.print("Your Simple Interest is: "+si);
    }
}
