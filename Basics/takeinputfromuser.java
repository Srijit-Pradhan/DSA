package Basics;

import java.util.Scanner;

@SuppressWarnings("resource")

public class takeinputfromuser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter radius of circle: ");
        double r = sc.nextInt();
        double area = 3.14 * r * r;
        System.out.println("Area of circle is: " + area);
    }

}