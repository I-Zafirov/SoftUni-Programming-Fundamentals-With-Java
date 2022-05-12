package T19MidExamPreparation;

import java.util.Scanner;

public class CookingMasterclass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());

        double priceFlour = Double.parseDouble(scanner.nextLine());
        double priceEgg = Double.parseDouble(scanner.nextLine());
        double priceApron = Double.parseDouble(scanner.nextLine());

        double freeFlour = Math.floor(students / 5.00);

        double costs = priceApron * (students + Math.ceil(students * 0.2)) + priceEgg * 10 * students + priceFlour * (students - freeFlour);

        if (costs <= budget) {
            System.out.printf("Items purchased for %.2f$.", costs);
        } else {
            System.out.printf("%.2f$ more needed.", costs - budget);
        }
    }
}
