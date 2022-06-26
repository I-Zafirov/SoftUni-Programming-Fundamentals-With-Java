package T19MidExamPreparation;

import java.util.Scanner;

public class ExperienceGaining2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double neededExperience = Double.parseDouble(scanner.nextLine());
        int countBattles = Integer.parseInt(scanner.nextLine());
        double experiencePerBattles = 0;
        double collectEx = 0;
        boolean heMadeIt = false;
        int battlesCount = 0;

        for (int i = 1; i <= countBattles; i++) {
            experiencePerBattles = Integer.parseInt(scanner.nextLine());
            if (i % 3 == 0) {
                experiencePerBattles += experiencePerBattles * 0.15;

            }
            if (i % 5 == 0) {
                experiencePerBattles -= experiencePerBattles * 0.10;

            }
            collectEx += experiencePerBattles;
            if (collectEx >= neededExperience) {
                battlesCount++;
                break;
            }
            battlesCount++;
        }
        if (collectEx >= neededExperience) {
            System.out.printf("Player successfully collected his needed experience for %d battles.", battlesCount);
        } else if (collectEx < neededExperience) {
            System.out.printf("Player was not able to collect the needed experience, %.2f more needed.", neededExperience - collectEx);
        }

    }
}
