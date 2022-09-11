package T19MidExamPreparation;

import java.util.Scanner;

public class NextLevel {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double NeededExperience = Double.parseDouble(scan.nextLine());
        int countBattles = Integer.parseInt(scan.nextLine());
        double experience = 0;
        for (int i = 1; i <= countBattles; i++) {
            double currentExp = Double.parseDouble(scan.nextLine());
            experience += currentExp;
            if (i % 3 == 0) {
                currentExp *= 0.15;
                experience += currentExp;
            }
            if (i % 5 == 0) {
                currentExp *= 0.1;
                experience -= currentExp;

            }
            if (i % 15 == 0) {
                currentExp *= 0.05;
                experience += currentExp;
            }

            if (experience >= NeededExperience) {
                System.out.printf("Player successfully collected his needed experience for %d battles.", i);
                return;
            }
        }

        if (experience >= NeededExperience) {
            System.out.printf("Player successfully collected his needed experience for %d battles.", countBattles);
        } else {
            System.out.printf("Player was not able to collect the needed experience, %.2f more needed.", NeededExperience - experience);

        }
    }
}
