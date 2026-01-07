package Basics;

public class totalsurfaceareaofcuboid {
    public static void main(String[] args) {
        // total surface area of cuboid = 2*(l*b + b*h + h*l)
        double l = 5;
        double b = 4;
        double h = 3;
        double tsa = 2 * (l * b + b * h + h * l);
        System.out.println("Total Surface Area of Cuboid is: " + tsa);
    }
}
