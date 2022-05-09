package T19MidExamPreparation;

import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int students = scanner.nextInt();
        int lectures = scanner.nextInt();
        int initialBonus = scanner.nextInt();

        double maxBonus = 0.0;
        int maxAttendances = 0;

        for (int i = 0; i < students; i++) {
            int attendances = scanner.nextInt();
            double totalBonus = attendances / (double) lectures * (5 + initialBonus);

            if (totalBonus > maxBonus) {
                maxBonus = totalBonus;
                maxAttendances = attendances;
            }
        }
        System.out.printf("Max Bonus: %.0f.%n", maxBonus);
        System.out.printf("The student has attended %d lectures.", maxAttendances);
    }
}
