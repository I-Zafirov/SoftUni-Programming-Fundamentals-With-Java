package T19MidExamPreparation;

import java.util.Scanner;

public class CookingMasterclass2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double flourPrice = Double.parseDouble(scanner.nextLine());
        double eggPrice = Double.parseDouble(scanner.nextLine());
        double apronPrice = Double.parseDouble(scanner.nextLine());
        double neededMoney = 0;

        neededMoney += (students - (students / 5)) * flourPrice;
        neededMoney += students * 10 * eggPrice;
        neededMoney += (students + (Math.ceil(0.2 * students))) * apronPrice;

        if (neededMoney <= budget) {
            System.out.printf("Items purchased for %.2f$.", neededMoney);
        } else {
            System.out.printf("%.2f$ more needed.", neededMoney - budget);
        }
    }
}
