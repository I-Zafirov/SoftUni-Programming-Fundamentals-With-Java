package T33FinExamPreparation;

import java.util.Scanner;
import java.util.TreeMap;

public class BattleManager3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        TreeMap<String, Integer> personsAndHealth = new TreeMap<>();
        TreeMap<String, Integer> personsAndEnergy = new TreeMap<>();
        int countPeople = 0;
        while (!input.equals("Results")) {
            String[] tokens = input.split(":");
            String command = tokens[0];
            switch (command) {
                case "Add": {
                    String name = tokens[1];
                    int health = Integer.parseInt(tokens[2]);
                    int energy = Integer.parseInt(tokens[3]);
                    if (!personsAndEnergy.containsKey(name)) {
                        personsAndEnergy.put(name, energy);
                        personsAndHealth.put(name, health);
                        countPeople++;
                    } else {
                        int currentHealth = personsAndHealth.get(name);
                        int currentEnergy = personsAndEnergy.get(name);
                        personsAndHealth.put(name, currentHealth + health);
//                        personsAndEnergy.put(name,currentEnergy+energy);
                    }
                }
                break;
                case "Attack": {
                    String attackerName = tokens[1];
                    String defenderName = tokens[2];
                    int damage = Integer.parseInt(tokens[3]);
                    if (personsAndHealth.containsKey(attackerName) && personsAndHealth.containsKey(defenderName)) {
                        int currentHealth = personsAndHealth.get(defenderName);
                        int healthLeft = currentHealth - damage;
                        if (healthLeft <= 0) {
                            personsAndHealth.remove(defenderName);
                            personsAndEnergy.remove(defenderName);
                            System.out.printf("%s was disqualified!%n", defenderName);
                            countPeople--;
                        } else {
                            personsAndHealth.put(defenderName, healthLeft);
                        }
                        int currentEnergy = personsAndEnergy.get(attackerName);
                        int energyLeft = currentEnergy - 1;
                        if (energyLeft <= 0) {
                            personsAndEnergy.remove(attackerName);
                            personsAndHealth.remove(attackerName);
                            countPeople--;
                            System.out.printf("%s was disqualified!%n", attackerName);
                        } else {
                            personsAndEnergy.put(attackerName, energyLeft);
                        }
                    }
                }
                break;
                case "Delete": {
                    String userToDelete = tokens[1];
                    if (userToDelete.equals("All")) {
                        personsAndEnergy.clear();
                        personsAndHealth.clear();
                        countPeople = 0;
                    } else {
                        if (personsAndHealth.containsKey(userToDelete)) {
                            personsAndHealth.remove(userToDelete);
                            personsAndEnergy.remove(userToDelete);
                            countPeople--;
                        }
                    }
                }
                break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("People count: %d%n", countPeople);
        personsAndHealth.entrySet().stream().sorted((p1, p2) -> p2.getValue().compareTo(p1.getValue()))
                .forEach(p -> {
                            System.out.printf("%s - ", p.getKey());
                            System.out.printf("%d - ", p.getValue());
                            System.out.printf("%d", personsAndEnergy.get(p.getKey()));
                            System.out.println();
                        }
                );
    }
}
