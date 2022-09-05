package T19MidExamPreparation;

import java.util.Scanner;

public class ManOWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstInput = scanner.nextLine().split("\\>");
        int[] pirate = new int[firstInput.length];

        for (int i = 0; i < pirate.length; i++) {
            pirate[i] = Integer.parseInt(firstInput[i]);
        }
        String[] secondInput = scanner.nextLine().split("\\>");
        int[] warship = new int[secondInput.length];
        for (int i = 0; i < warship.length; i++) {
            warship[i] = Integer.parseInt(secondInput[i]);
        }
        int healthCapacity = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        while (!"Retire".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Fire":
                    int index = Integer.parseInt(tokens[1]);
                    int damage = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index < warship.length) {
                        int section = warship[index];
                        section -= damage;
                        if (section <= 0) {
                            System.out.println("You won! The enemy ship has sunken.");
                            return;
                        } else {
                            warship[index] = section;
                        }
                    }
                    break;
                case "Defend":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    damage = Integer.parseInt(tokens[3]);
                    if (startIndex >= 0 && startIndex < pirate.length && endIndex >= 0 && endIndex < pirate.length) {
                        for (int i = startIndex; i <= endIndex; i++) {
                            int current = pirate[i] - damage;
                            if (current <= 0) {
                                System.out.println("You lost! The pirate ship has sunken.");
                                return;
                            } else {
                                pirate[i] = current;
                            }
                        }
                    }
                    break;
                case "Repair":
                    index = Integer.parseInt(tokens[1]);
                    int health = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index < pirate.length) {
                        pirate[index] += health;
                        if (pirate[index] > healthCapacity) {
                            pirate[index] = healthCapacity;
                        }
                    }
                    break;
                case "Status":
                    int count = 0;
                    for (int i = 0; i < pirate.length; i++) {
                        if (pirate[i] < 0.2 * healthCapacity) {
                            count++;
                        }
                    }
                    System.out.printf("%d sections need repair.%n", count);
                    break;
            }
            input = scanner.nextLine();
        }
        int sumOfPirate = 0;
        int sumOfWarship = 0;
        for (int i = 0; i < pirate.length; i++) {
            sumOfPirate += pirate[i];
        }
        for (int i = 0; i < warship.length; i++) {
            sumOfWarship += warship[i];
        }
        System.out.printf("Pirate ship status: %d%n", sumOfPirate);
        System.out.printf("Warship status: %d%n", sumOfWarship);
    }
}
