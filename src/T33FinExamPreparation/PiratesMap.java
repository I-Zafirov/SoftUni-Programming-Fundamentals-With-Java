package T33FinExamPreparation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PiratesMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, int[]> cities = new LinkedHashMap<>();

        String command = scanner.nextLine();

        while (!command.equals("Sail")) {
            String[] infoCities = command.split("\\|\\|");
            String town = infoCities[0];
            int population = Integer.parseInt(infoCities[1]);
            int gold = Integer.parseInt(infoCities[2]);

            if (cities.get(town) == null) {
                cities.put(town, new int[]{0, 0});
            }
            if (cities.containsKey(town)) {
                cities.get(town)[0] += population;
                cities.get(town)[1] += gold;
            }

            command = scanner.nextLine();
        }

        command = scanner.nextLine();

        while (!command.equals("End")) {
            String[] events = command.split("=>");
            switch (events[0]) {
                case "Plunder":
                    String town = events[1];
                    int people = Integer.parseInt(events[2]);
                    int gold = Integer.parseInt(events[3]);
                    cities.get(town)[0] -= people;
                    cities.get(town)[1] -= gold;
                    System.out.println(String.format("%s plundered! %d gold stolen, %d citizens killed.", town, gold, people));
                    if (cities.get(town)[0] <= 0 | cities.get(town)[1] <= 0) {
                        cities.remove(town);
                        System.out.printf("%s has been wiped off the map!%n", town);
                    }
                    break;
                case "Prosper":
                    town = events[1];
                    gold = Integer.parseInt(events[2]);
                    if (gold > 0) {
                        cities.get(town)[1] += gold;
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n",
                                gold, town, cities.get(town)[1]);
                    } else {
                        System.out.println("Gold added cannot be a negative number!");
                    }
                    break;
            }
            command = scanner.nextLine();
        }

        int count = cities.size();
        if (count > 0) {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", count);
            cities.entrySet().stream()
                    .sorted((f, s) -> {
                        int result = s.getValue()[1] - f.getValue()[1];
                        if (result == 0) {
                            result = f.getKey().compareTo(s.getKey());
                        }
                        return result;
                    }).forEach(e -> System.out.println(e.getKey() + " -> " + "Population: " + e.getValue()[0] + " citizens, Gold: " + e.getValue()[1] + " kg"));
        } else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }

    }
}
