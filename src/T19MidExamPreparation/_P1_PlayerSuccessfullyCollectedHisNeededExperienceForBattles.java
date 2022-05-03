package T19MidExamPreparation;

import java.util.Scanner;

public class _P1_PlayerSuccessfullyCollectedHisNeededExperienceForBattles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double neededEx = Double.parseDouble(scanner.nextLine());
        int battles = Integer.parseInt(scanner.nextLine());
        double sum = 0.0;

        for (int i = 1; i <= battles; i++) {
            double exPerBattle = Double.parseDouble(scanner.nextLine());
            sum += exPerBattle;
            if (i % 3 == 0) {
                sum += 0.15 * exPerBattle;
            }
            if (i % 5 == 0) {
                sum -= 0.1 * exPerBattle;
            }
            if (i % 15 == 0) {
                sum += 0.05 * exPerBattle;
            }
            if (sum >= neededEx) {
                System.out.printf("Player successfully collected his needed experience for %d battles.", i);
                return;
            }
        }
        System.out.printf("Player was not able to collect the needed experience, %.2f more needed.", neededEx - sum);
    }
}
