package T33FinExamPreparation;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class GoldAddedToTheCityTreasury2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, ArrayList<Integer>> towns = new TreeMap<>();

        String input = scan.nextLine();

        while (!input.equals("Sail")) {
            String[] tokens = input.split("\\|\\|");
            String city = tokens[0];
            int population = Integer.parseInt(tokens[1]);

            int gold = Integer.parseInt(tokens[2]);

            if (!towns.containsKey(city)) {
                towns.put(city, new ArrayList<Integer>());
                towns.get(city).add(0, population);     // index 0 = population
                towns.get(city).add(1, gold);           // index 1 = gold
            } else if (towns.containsKey(city)) {
                int oldPopulation = towns.get(city).get(0);
                int oldGold = towns.get(city).get(1);
                towns.get(city).set(0, (oldPopulation + population));
                towns.get(city).set(1, (oldGold + gold));
            }

            input = scan.nextLine();
        }
        input = scan.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split("=>");
            String cmd = tokens[0];

            switch (cmd) {
                case "Plunder":
                    String townPlundered = tokens[1];
                    if (towns.containsKey(townPlundered)) {
                        int oldPopulation = towns.get(townPlundered).get(0);
                        int oldGold = towns.get(townPlundered).get(1);
                        towns.get(townPlundered).set(0, oldPopulation - Integer.parseInt(tokens[2]));
                        towns.get(townPlundered).set(1, oldGold - Integer.parseInt(tokens[3]));
                        System.out.println(String.format("%s plundered! %d gold stolen, %d citizens killed.", townPlundered, Integer.parseInt(tokens[3]), Integer.parseInt(tokens[2])));
                    } else {
                        break;
                    }

                    if (towns.get(townPlundered).get(0) <= 0 || towns.get(townPlundered).get(1) <= 0) {
                        towns.remove(townPlundered);
                        System.out.println(String.format("%s has been wiped off the map!", townPlundered));
                    }
                    break;

                case "Prosper":
                    String townProsper = tokens[1];
                    int goldGrowth = Integer.parseInt(tokens[2]);

                    if (towns.containsKey(townProsper)) {


                        if (goldGrowth < 0) {
                            System.out.println("Gold added cannot be a negative number!");
                        } else if (goldGrowth > 0) {
                            int oldGold = towns.get(townProsper).get(1);
                            towns.get(townProsper).set(1, oldGold + goldGrowth);
                            System.out.println(String.format("%s gold added to the city treasury. %s now has %d gold.", goldGrowth, townProsper, towns.get(townProsper).get(1)));
                        } else {
                            break;
                        }
                    }

                    break;
            }
            input = scan.nextLine();
        }
        System.out.println(String.format("Ahoy, Captain! There are %d wealthy settlements to go to:", towns.size()));
        towns
                .entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().get(1) - a.getValue().get(1))
                .forEach(e -> System.out.println(String.format("%s -> Population: %d citizens, Gold: %d kg", e.getKey(), e.getValue().get(0), e.getValue().get(1))));
    }
}
