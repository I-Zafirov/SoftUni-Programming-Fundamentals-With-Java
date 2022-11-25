package T33FinExamPreparation;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Pirates2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, CityInformation> mapCity = new TreeMap<>();
        while (!input.equals("Sail")) {
            String[] commandData = input.split("\\|\\|");
            String city = commandData[0];
            int population = Integer.parseInt(commandData[1]);
            int gold = Integer.parseInt(commandData[2]);
            if (!mapCity.containsKey(city)) {
                CityInformation cityData = new CityInformation(population, gold);
                mapCity.put(city, cityData);
            } else {
                int oldPopulation = mapCity.get(city).getPopulation();
                int oldGold = mapCity.get(city).getGold();
                int newPopulation = oldPopulation + population;
                int newGold = oldGold + gold;
                mapCity.get(city).setPopulation(newPopulation);
                mapCity.get(city).setGold(newGold);
            }
            input = scanner.nextLine();
        }
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] commandLine = command.split("=>");
            switch (commandLine[0]) {
                case "Plunder":
                    String town = commandLine[1];
                    int killedPeople = Integer.parseInt(commandLine[2]);
                    int stealGold = Integer.parseInt(commandLine[3]);
                    int currentPeople = mapCity.get(town).getPopulation();
                    int currentGold = mapCity.get(town).getGold();
                    int newPeople = currentPeople - killedPeople;
                    int newGold = currentGold - stealGold;
                    if (newPeople <= 0 || newGold <= 0) {
                        System.out.printf("%s plundered! %d gold stolen, %d citizens killed.\n"
                                , town, stealGold, killedPeople);
                        mapCity.remove(town);
                        System.out.printf("%s has been wiped off the map!\n", town);
                    } else {
                        mapCity.get(town).setPopulation(newPeople);
                        mapCity.get(town).setGold(newGold);
                        System.out.printf("%s plundered! %d gold stolen, %d citizens killed.\n"
                                , town, stealGold, killedPeople);
                    }
                    break;
                case "Prosper":
                    town = commandLine[1];
                    int addGold = Integer.parseInt(commandLine[2]);
                    if (addGold < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                        command = scanner.nextLine();
                        continue;
                    } else {
                        currentGold = mapCity.get(town).getGold();
                        newGold = currentGold + addGold;
                        mapCity.get(town).setGold(newGold);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.\n"
                                , addGold, town, newGold);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        if (mapCity.size() > 0) {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:\n"
                    , mapCity.size());
            mapCity.entrySet().stream().sorted((e1, e2) -> Integer.compare(e2.getValue().getGold()
                            , e1.getValue().getGold()))
                    .forEach(e -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg\n"
                            , e.getKey(), e.getValue().getPopulation(), e.getValue().getGold()));
        } else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }
    }

    static class CityInformation {
        private int population;
        private int gold;

        public CityInformation(int population, int gold) {
            this.population = population;
            this.gold = gold;
        }

        public int getPopulation() {
            return population;
        }

        public int getGold() {
            return gold;
        }

        public void setPopulation(int population) {
            this.population = population;
        }

        public void setGold(int gold) {
            this.gold = gold;
        }
    }
}

