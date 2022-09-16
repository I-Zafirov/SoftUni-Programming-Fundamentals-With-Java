package T19MidExamPreparation;

import java.util.Scanner;

public class SoftUniReception2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int capacityPerHour = scanner.nextInt() + scanner.nextInt() + scanner.nextInt();
        int studentsRemaining = scanner.nextInt();

        int hours = 0;
        while (studentsRemaining > 0){
            hours++; // first hour
            if (hours % 4 != 0){
                studentsRemaining -= capacityPerHour;
            }
        }

        System.out.printf("Time needed: %dh.%n", hours);
    }
}
