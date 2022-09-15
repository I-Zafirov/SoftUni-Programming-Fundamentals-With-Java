package T19MidExamPreparation;

import java.util.Scanner;

public class SeizeTheFire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("#");
        int water = Integer.parseInt(scanner.nextLine());

        double effort = 0.0;
        int totalFire = 0;

        System.out.println("Cells:");

        for (int i = 0; i < input.length; i++) {
            String[] fire = input[i].split(" = ");
            String fireLevel = fire[0];
            int neededWater = Integer.parseInt(fire[1]);
            boolean inRange = false;

            switch (fireLevel){
                case "High":
                    if (neededWater >= 81 && neededWater <= 125){
                        inRange = true;
                    }
                    break;
                case "Medium":
                    if (neededWater >= 51 && neededWater <= 80){
                        inRange = true;
                    }
                    break;
                case "Low":
                    if (neededWater >= 1 && neededWater <= 50){
                        inRange = true;
                    }
                    break;
            }

            if (water > 0 && water >= neededWater && inRange){
                water -= neededWater;
                System.out.printf(" - %d%n", neededWater);
                totalFire += neededWater;
                effort += neededWater * 0.25;
            }
        }

        System.out.printf("Effort: %.2f%n", effort);
        System.out.printf("Total Fire: %d", totalFire);
    }
}
