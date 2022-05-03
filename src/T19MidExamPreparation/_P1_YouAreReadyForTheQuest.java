package T19MidExamPreparation;

import java.util.Scanner;

public class _P1_YouAreReadyForTheQuest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int players = Integer.parseInt(scanner.nextLine());
        double groupEnergy = Double.parseDouble(scanner.nextLine());
        double waterPersonDay = Double.parseDouble(scanner.nextLine());
        double foodPersonDay = Double.parseDouble(scanner.nextLine());

        double totalWater = days * players * waterPersonDay;
        double totalFood = days * players * foodPersonDay;

        for (int i = 1; i <= days; i++) {
            double lostEnergy = Double.parseDouble(scanner.nextLine());
            groupEnergy -= lostEnergy;
            if (groupEnergy <= 0) {
                System.out.printf("You will run out of energy. You will be left with %.2f food and %.2f water."
                        , totalFood, totalWater);
                return;
            }
            if (i % 2 == 0) {
                groupEnergy = groupEnergy + groupEnergy * 0.05;
                totalWater -= totalWater * 0.3;
            }
            if (i % 3 == 0) {
                totalFood = totalFood - totalFood / players;
                groupEnergy = groupEnergy + groupEnergy * 0.1;
            }
        }
        System.out.printf("You are ready for the quest. You will be left with - %.2f energy!", groupEnergy);
    }
}
