package T19MidExamPreparation;

import java.util.Scanner;

public class CoffeeShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int orders = Integer.parseInt(scan.nextLine());
        double sum = 0;

        for(int i = 0; i<orders; i++){

            double pricePerCapsule = Double.parseDouble(scan.nextLine());
            int days = Integer.parseInt(scan.nextLine());
            int capsulesCount = Integer.parseInt(scan.nextLine());

            double formula= (days * capsulesCount) * pricePerCapsule;
            System.out.printf("The price for the coffee is: $%.2f\n", formula);
            sum+=formula;
        }

        System.out.printf("Total: $%.2f", sum);
    }
}
