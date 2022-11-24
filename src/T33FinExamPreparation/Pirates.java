package T33FinExamPreparation;

import java.util.HashMap;
import java.util.Scanner;

public class Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Integer> citiesAndPopulation = new HashMap<>();
        HashMap<String, Integer> citiesAndGold = new HashMap<>();
        String input = scanner.nextLine();

        while (!"Sail".equals(input)) {
            String[] tokens = input.split("\\|\\|");
            String city = tokens[0];
            int population = Integer.parseInt(tokens[1].trim());
            int gold = Integer.parseInt(tokens[2].trim());

            if (!citiesAndPopulation.containsKey(city)) {
                citiesAndPopulation.put(city, population);
                citiesAndGold.put(city, gold);
            } else {
                citiesAndPopulation.put(city, citiesAndPopulation.get(city) + population);
                citiesAndGold.put(city, citiesAndGold.get(city) + gold);
            }

            /*
            Integer currentPopulation = citiesAndPopulation.get(city);
            if (currentPopulation == null){
                currentPopulation = 0;
            }
            citiesAndPopulation.put(city, currentPopulation + population);
            Integer currentGold = citiesAndGold.get(city);
            if (currentGold == null){
                currentGold = 0;
            }
            citiesAndGold.put(city, currentGold + gold);
            */

            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("=>");
            String command = tokens[0];
            String town = tokens[1];
            switch (command) {
                case "Plunder":
                    int people = Integer.parseInt(tokens[2].trim());
                    int gold = Integer.parseInt(tokens[3].trim());
                    citiesAndPopulation.put(town, citiesAndPopulation.get(town) - people);
                    citiesAndGold.put(town, citiesAndGold.get(town) - gold);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, gold, people);
                    if (citiesAndPopulation.get(town) <= 0 || citiesAndGold.get(town) <= 0) {
                        citiesAndPopulation.remove(town);
                        citiesAndGold.remove(town);
                        System.out.printf("%s has been wiped off the map!%n", town);
                    }
                    break;
                case "Prosper":
                    gold = Integer.parseInt(tokens[2]);
                    if (gold < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                        break;
                    }
                    citiesAndGold.put(town, citiesAndGold.get(town) + gold);
                    System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", gold, town, citiesAndGold.get(town));
                    break;
            }

            input = scanner.nextLine();
        }
        if (citiesAndGold.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", citiesAndGold.size());
            citiesAndGold.entrySet()
                    .stream()
                    .sorted((f, s) -> {
                        int result = s.getValue().compareTo(f.getValue());
                        if (result == 0) {
                            result = f.getKey().compareTo(s.getKey());
                        }
                        return result;
                    }).forEach(city -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",
                            city.getKey(), citiesAndPopulation.get(city.getKey()), city.getValue()));
        }
    }
}
