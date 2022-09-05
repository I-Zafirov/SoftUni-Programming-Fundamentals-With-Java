package T19MidExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManOWar2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pirateShipInput = scanner.nextLine().split(">");
        List<Integer> pirateShip = new ArrayList<>();

        for (String currentSector : pirateShipInput) {
            pirateShip.add(Integer.parseInt(currentSector));
        }
        String[] warShipInput = scanner.nextLine().split(">");
        List<Integer> warShip = new ArrayList<>();

        for (String currentSector : warShipInput) {
            warShip.add(Integer.parseInt(currentSector));
        }
        int maxHealth = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("Retire")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Fire":
                    int index = Integer.parseInt(tokens[1]);
                    int damage = Integer.parseInt(tokens[2]);
                    if (isValid(index, warShip.size())) {
                        int damagedSector = warShip.get(index);
                        damagedSector -= damage;
                        if (damagedSector <= 0) {
                            System.out.println("You won! The enemy ship has sunken.");
                            return;
                        } else {
                            warShip.set(index, damagedSector);
                        }
                    }
                    break;
                case "Defend":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    int receivedDamage = Integer.parseInt(tokens[3]);
                    if (isValid(startIndex, pirateShip.size()) && isValid(endIndex, pirateShip.size())) {
                        for (int i = startIndex; i <= endIndex; i++) {
                            int damagedSectors = pirateShip.get(i);
                            damagedSectors -= receivedDamage;
                            if (damagedSectors <= 0) {
                                System.out.println("You lost! The pirate ship has sunken.");
                                return;
                            } else {
                                pirateShip.set(i, damagedSectors);
                            }
                        }
                    }
                    break;
                case "Repair":
                    int indexToBeRepaired = Integer.parseInt(tokens[1]);
                    int healthToBeAdded = Integer.parseInt(tokens[2]);
                    if (isValid(indexToBeRepaired, pirateShip.size())) {
                        int currentSector = pirateShip.get(indexToBeRepaired);
                        currentSector += healthToBeAdded;
                        if (currentSector > maxHealth) {
                            maxHealth = currentSector;
                        }
                        pirateShip.set(indexToBeRepaired, currentSector);
                    } else {
                        break;
                    }
                    break;
                case "Status":
                    int sectorsCount = 0;
                    for (Integer currentSector : pirateShip) {
                        if (currentSector < maxHealth * 0.20) {
                            sectorsCount++;
                        }
                    }
                    System.out.printf("%d sections need repair.%n", sectorsCount);
                    break;
            }
            input = scanner.nextLine();
        }
        printPirateShipSum(pirateShip);
        printWarShipSum(warShip);
    }

    private static void printWarShipSum(List<Integer> warShip) {
        int sumOfSections = 0;
        for (Integer currentSection : warShip) {
            sumOfSections += currentSection;
        }
        System.out.printf("Warship status: %d%n", sumOfSections);
    }

    private static void printPirateShipSum(List<Integer> pirateShip) {
        int sumOfSections = 0;
        for (Integer currentSection : pirateShip) {
            sumOfSections += currentSection;
        }
        System.out.printf("Pirate ship status: %d%n", sumOfSections);
    }

    private static boolean isValid(int index, int size) {
        return index >= 0 && index <= size - 1;
    }
}
