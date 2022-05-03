package T19MidExamPreparation;

import java.util.Scanner;

public class _P1_PriceCoffeeTotal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int countOrders = Integer.parseInt(scanner.nextLine());
        double priceOrder = 0;
        double priceTotal = 0;

        for (int i = 0; i<countOrders; i++){
            double pricePerCapsule = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            int capsulesCount = Integer.parseInt(scanner.nextLine());
            priceOrder = (days * capsulesCount) * pricePerCapsule;
            System.out.printf("The price for the coffee is: $%.2f%n",priceOrder);
            priceTotal+=priceOrder;
            // break;
        }

        System.out.printf("Total: $%.2f%n", priceTotal);
    }
}
