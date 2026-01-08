public class typecasting {
    public static void main(String[] args) {
        char ch = 'A';
        System.out.println("Ascii value: " + (int) ch);
        System.out.println("Ascii value: " + (ch+0));

        // int to char

        int x=65;
        char c = (char)x;
        System.out.println("Character value: " + c);

        //char to int

        char a='B';
        int y = (int)a;
        System.out.println("Integer value: " + y);

        // double to int
        double d = 45.67;
        int i = (int)d;
        System.out.println("Double to int: " + i);

        // int to double
        int m = 45;
        double n = (double)m;   
        System.out.println("Int to double: " + n);
    }
}
