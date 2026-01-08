import java.util.Scanner;
@SuppressWarnings("resource")//must be added to avoid resource leak warning
public class squareofanumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);//creates a Scanner object to read input

        System.out.print("Enter a number to find its square: ");
        int num = sc.nextInt();//reads an integer input from user
        int square = num * num;
        System.out.println("The square of " + num + " is: " + square);
    }
}
