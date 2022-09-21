package T19MidExamPreparation;

import java.util.Scanner;

public class TheHuntingGames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = scanner.nextInt();
        int players = scanner.nextInt();
        double energy = scanner.nextDouble();
        double waterPerPersonPerDay = scanner.nextDouble();
        double foodPerPersonPerDay = scanner.nextDouble();

        double totalWater = days * players * waterPerPersonPerDay;
        double totalFood = days * players * foodPerPersonPerDay;

        for (int i = 1; i <= days; i++) {
            double energyLoss = scanner.nextDouble();
            energy -= energyLoss;
            if (energy <= 0){
                System.out.printf("You will run out of energy. You will be left with %.2f food and %.2f water.",
                        totalFood, totalWater);
                return;
            }
            if (i % 2 == 0){
                energy *= 1.05;
                totalWater *= 0.70;
            }
            if (i % 3 == 0){
                energy *= 1.10;
                totalFood -= totalFood / players;
            }
        }
        System.out.printf("You are ready for the quest. You will be left with - %.2f energy!", energy);
    }
}
