package T33FinExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManOWar2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pirateShip = scanner.nextLine().split(">");
        List<Integer> pirateSections = new ArrayList<>();
        for (int i = 0; i < pirateShip.length; i++) {
            int section = Integer.parseInt(pirateShip[i]);
            pirateSections.add(section);
        }
        String[] warship = scanner.nextLine().split(">");
        List<Integer> warshipSections = new ArrayList<>();
        for (int i = 0; i < warship.length; i++) {
            int section = Integer.parseInt(warship[i]);
            warshipSections.add(section);
        }
        int maxHealth = Integer.parseInt(scanner.nextLine());

        String command = scanner.nextLine();
        while (!"Retire".equals(command)) {
            String[] tokens = command.split("\\s+");
            switch (tokens[0]) {
                case "Fire":
                    int sectionIndex = Integer.parseInt(tokens[1]);
                    int damage = Integer.parseInt(tokens[2]);
                    if (sectionIndex < 0 || sectionIndex >= warshipSections.size()) {
                        break;
                    }
                    int sectionHealth = warshipSections.get(sectionIndex);
                    sectionHealth -= damage;
                    if (sectionHealth <= 0) {
                        System.out.println("You won! The enemy ship has sunken.");
                        return;
                    }
                    warshipSections.set(sectionIndex, sectionHealth);
                    break;
                case "Defend":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    int damageDealt = Integer.parseInt(tokens[3]);
                    if (startIndex < 0 || startIndex >= pirateSections.size()) {
                        break;
                    }
                    if (endIndex < 0 || endIndex >= pirateSections.size()) {
                        break;
                    }
                    for (int i = startIndex; i <= endIndex; i++) {
                        int health = pirateSections.get(i);
                        health -= damageDealt;
                        if (health <= 0) {
                            System.out.println("You lost! The pirate ship has sunken.");
                            return;
                        }
                        pirateSections.set(i, health);
                    }
                    break;
                case "Repair":
                    int index = Integer.parseInt(tokens[1]);
                    int repairHealth = Integer.parseInt(tokens[2]);
                    if (index < 0 || index >= pirateSections.size()) {
                        break;
                    }
                    int section = pirateSections.get(index);
                    section += repairHealth;
                    pirateSections.set(index, Math.min(maxHealth, section));
                    break;
                case "Status":
                    int counter = 0;
                    double threshold = maxHealth * 0.2;
                    for (Integer pirateSection : pirateSections) {
                        if (pirateSection < threshold) {
                            counter++;
                        }
                    }
                    System.out.printf("%d sections need repair.%n", counter);
                    break;
            }

            command = scanner.nextLine();
        }
        int pirateSum = pirateSections.stream().mapToInt(Integer::intValue).sum();
        int warshipSum = warshipSections.stream().mapToInt(Integer::intValue).sum();

        System.out.println("Pirate ship status: " + pirateSum);
        System.out.println("Warship status: " + warshipSum);
    }
}
