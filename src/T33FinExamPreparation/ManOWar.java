package T33FinExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManOWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pirateShip = scanner.nextLine().split(">");
        List<Integer> pirateSections = new ArrayList<>();
        for (int i = 0; i < pirateShip.length; i++) {
            pirateSections.add(Integer.parseInt(pirateShip[i]));
        }
        String[] warship = scanner.nextLine().split(">");
        List<Integer> warshipSections = new ArrayList<>();
        for (int i = 0; i < warship.length; i++) {
            warshipSections.add(Integer.parseInt(warship[i]));
        }
        int maxHealth = Integer.parseInt(scanner.nextLine());

        String command = scanner.nextLine();
        while (!command.equals("Retire")) {
            String[] commandParts = command.split(" ");
            switch (commandParts[0]) {
                case "Fire":
                    int indexOne = Integer.parseInt(commandParts[1]);
                    int indexTwo = Integer.parseInt(commandParts[2]);
                    if (indexOne >= warshipSections.size() || indexOne < 0) {
                        break;
                    }
                    int newValue = warshipSections.get(indexOne) - indexTwo;
                    warshipSections.set(indexOne, newValue);
                    if (newValue < 0) {
                        System.out.println("You won! The enemy ship has sunken.");
                        return;
                    }
                    break;
                case "Defend":
                    int startIndex = Integer.parseInt(commandParts[1]);
                    int endIndex = Integer.parseInt(commandParts[2]);
                    int damageDealt = Integer.parseInt(commandParts[3]);

                    for (int i = startIndex; i < endIndex; i++) {
                        int damaged = pirateSections.get(i) - damageDealt;
                        pirateSections.set(i, damaged);
                    }
                    break;
                case "Repair":
                    int index = Integer.parseInt(commandParts[1]);
                    int repairHealth = Integer.parseInt(commandParts[2]);
                    pirateSections.set(index, pirateSections.get(index) + repairHealth);
                    break;
                case "Status":
                    int counter = 0;
                    for (int i = 0; i < pirateSections.size(); i++) {
                        if (pirateSections.get(i) < maxHealth * 0.2) {
                            counter++;
                        }
                    }
                    System.out.printf("%d sections need repair.", counter);
                    break;
            }
        }
        int pirateSum = 0;
        int warshipSum = 0;
        for (Integer pirateSection : pirateSections) {
            pirateSum = pirateSum + pirateSection;
        }
        for (Integer warshipSection : warshipSections) {
            warshipSum = warshipSum + warshipSection;
        }
        System.out.println("Pirate ship status: " + pirateSum);
        System.out.println("Warship status: " + warshipSum);
    }
}
