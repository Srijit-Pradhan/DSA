package if_else;

import java.util.Scanner;
@SuppressWarnings("resource")

public class profit_loss {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("cost price: ");
        int cp = sc.nextInt();
        System.out.println("selling price: ");
        int sp = sc.nextInt();

        int losspercent = ((cp - sp) * 100) / cp;
        int profitpercent = ((sp - cp) *100) / cp;

        if (sp > cp)
            System.out.println("profit is " + profitpercent + "%");
        else if (cp > sp)
            System.out.println("loss is " + losspercent + "%");
        else
            System.out.println("no profit no loss");
    }
}
