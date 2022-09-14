package T19MidExamPreparation;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Pirates2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] command = scan.nextLine().split("\\|\\|");

        Map<String, Integer> population = new TreeMap<>();
        Map<String, Integer> gold = new TreeMap<>();
        int wealthyCities = 0;

        while (!command[0].equals("Sail")) {
            String city = command[0];
            int cityPopulation = Integer.parseInt(command[1]);
            int cityGold = Integer.parseInt(command[2]);

            if (!population.containsKey(city)) {
                wealthyCities++;
            }
            population.putIfAbsent(city, 0);
            population.put(city, population.get(city) + cityPopulation);

            gold.putIfAbsent(city, 0);
            gold.put(city, gold.get(city) + cityGold);

            command = scan.nextLine().split("\\|\\|");
        }

        String[] secondCommand = scan.nextLine().split("=>");

        while (!secondCommand[0].equals("End")) {
            String city = secondCommand[1];

            switch (secondCommand[0]) {
                case "Plunder":
                    int populationKilled = Integer.parseInt(secondCommand[2]);
                    int goldLooted = Integer.parseInt(secondCommand[3]);

                    population.put(city, population.get(city) - populationKilled);
                    gold.put(city, gold.get(city) - goldLooted);
                    System.out.println(city + " plundered! " + goldLooted + " gold stolen, " + populationKilled + " citizens killed.");

                    if (population.get(city) <= 0) {
                        System.out.println(city + " has been wiped off the map!");

                        wealthyCities--;
                        population.remove(city);
                        gold.remove(city);
                    } else if (gold.get(city) <= 0) {
                        System.out.println(city + " has been wiped off the map!");

                        wealthyCities--;
                        gold.remove(city);
                        population.remove(city);
                    }

                    break;
                case "Prosper":
                    int goldGained = Integer.parseInt(secondCommand[2]);
                    if (goldGained >= 0) {
                        gold.put(city, gold.get(city) + goldGained);

                        System.out.print(goldGained + " gold added to the city treasury. ");
                        System.out.println(city + " now has " + gold.get(city) + " gold.");

                    } else {
                        System.out.println("Gold added cannot be a negative number!");
                    }
                    break;
            }
            secondCommand = scan.nextLine().split("=>");
        }
        if (gold.isEmpty() && population.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");

        } else {
            System.out.println("Ahoy, Captain! There are " + wealthyCities + " wealthy settlements to go to:");
            gold.entrySet().stream()
                    .sorted((a, b) -> {
                        int sortByGold = b.getValue();
                        int sortByName = a.getValue();
                        return Integer.compare(sortByGold, sortByName);
                    })
                    .forEach(e -> {
                        String name1 = e.getKey();
                        int name1Value = e.getValue();
                        int name2 = population.get(name1);
                        System.out.printf("%s -> Population: %d citizens, Gold: %d kg\n", name1, name2, name1Value);});
        }
    }
}
