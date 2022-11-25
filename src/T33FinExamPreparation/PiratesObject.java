package T33FinExamPreparation;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class PiratesObject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, City> cities = new HashMap<>();

        String input;
        while (!"Sail".equals(input = scanner.nextLine().trim())) {
            String[] tokens = input.split("\\|\\|");
            String cityName = tokens[0];
            int population = Integer.parseInt(tokens[1]);
            int gold = Integer.parseInt(tokens[2]);

            cities.compute(cityName, (name, city) ->
                    Objects.isNull(city) ?
                            new City(cityName, population, gold) :
                            city.updateCity(population, gold));
        }

        while (!"End".equals(input = scanner.nextLine().trim())) {
            String[] tokens = input.split("=>");
            String command = tokens[0];
            String cityName = tokens[1];

            switch (command) {
                case "Plunder":
                    int citizensKilled = Integer.parseInt(tokens[2]);
                    int goldStolen = Integer.parseInt(tokens[3]);
                    cities.computeIfPresent(cityName, plunderCity(cityName, citizensKilled, goldStolen));
                    break;
                case "Prosper":
                    int newGold = Integer.parseInt(tokens[2]);
                    cities.computeIfPresent(cityName, prosperCity(cityName, newGold));
                    break;
                default:
                    throw new UnsupportedOperationException("Unknown command: " + command);
            }
        }

        if (cities.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n%s%n",
                    cities.size(),
                    cities.values()
                            .stream()
                            .sorted(Comparator.comparingInt(City::getGold).reversed().thenComparing(City::getName))
                            .map(City::info)
                            .collect(Collectors.joining(System.lineSeparator())));
        }
    }

    private static BiFunction<String, City, City> plunderCity(String cityName, int citizensKilled, int goldStolen) {
        return (name, city) -> {
            System.out.printf(
                    "%s plundered! %d gold stolen, %d citizens killed.%n",
                    cityName, goldStolen, citizensKilled);
            if (city.plunderCity(citizensKilled, goldStolen).isDestroyed()) {
                System.out.printf("%s has been wiped off the map!%n", cityName);
                return null;
            }
            return city;
        };
    }

    private static BiFunction<String, City, City> prosperCity(String cityName, int newGold) {
        return (name, city) -> {
            if (city.prosperCity(newGold)) {
                System.out.printf(
                        "%d gold added to the city treasury. %s now has %d gold.%n",
                        newGold, cityName, city.getGold());
            } else {
                System.out.println("Gold added cannot be a negative number!");
            }
            return city;
        };
    }

    private static class City {
        private final String name;
        private int population;
        private int gold;

        public City(String name, int population, int gold) {
            this.name = name;
            this.population = population;
            this.gold = gold;
        }

        public String getName() {
            return this.name;
        }

        public int getGold() {
            return gold;
        }

        public boolean prosperCity(int gold) {
            if (gold < 0) {
                return false;
            }

            updateCity(0, gold);
            return true;
        }

        public City updateCity(int population, int gold) {
            this.population += population;
            this.gold += gold;
            return this;
        }

        public City plunderCity(int population, int gold) {
            updateCity(-population, -gold);
            return this;
        }

        public boolean isDestroyed() {
            return population <= 0 || gold <= 0;
        }

        public String info() {
            return String.format(
                    "%s -> Population: %d citizens, Gold: %d kg",
                    name, population, gold);
        }
    }
}
