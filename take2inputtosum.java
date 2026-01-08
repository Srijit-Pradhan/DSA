import java.util.Scanner;
@SuppressWarnings("resource")

public class take2inputtosum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter first no: ");
        int num1 = sc.nextInt();
        System.out.println("enter second no: ");
        int num2 = sc.nextInt();

        int sum = num1 + num2;
        System.out.println("The sum of two numbers: " + sum);
    }
}
