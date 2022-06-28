package T19MidExamPreparation;

import java.util.Scanner;

public class GuineaPig2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double quantityFood = Double.parseDouble(scanner.nextLine());
        double quantityHay = Double.parseDouble(scanner.nextLine());
        double quantityCover = Double.parseDouble(scanner.nextLine());
        double weight = Double.parseDouble(scanner.nextLine());

        int counterDays = 0;
        while (quantityFood > 0 && quantityHay > 0 && quantityCover > 0) {
            counterDays++;

            quantityFood -= 0.300;

            if (counterDays % 2 == 0) {
                quantityHay -= (0.05 * quantityFood);
            }

            if (counterDays % 3 == 0) {
                quantityCover -= (weight / 3);
            }
            if (counterDays == 30) {
                break;
            }
        }

        if (quantityFood > 0 && quantityHay > 0 && quantityCover > 0) {
            System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.",
                    quantityFood, quantityHay, quantityCover);
        } else {
            System.out.println("Merry must go to the pet store!");
        }
    }
}
