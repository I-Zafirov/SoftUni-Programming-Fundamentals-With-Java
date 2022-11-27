package T33FinExamPreparation;

import java.util.*;

public class PlantDiscoveryObject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Plant> plants = new HashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("<->");
            String name = data[0];
            int rarity = Integer.parseInt(data[1]);
            Plant plant = new Plant(name, rarity);
            plants.put(plant.getName(), plant);

            /*if (!plants.containsKey(name)){
                Plant plant = new Plant(name, rarity);
                plants.put(name, plant);
            } else {
                plants.get(name).setRarity(rarity);
            }*/
        }

        String input = scanner.nextLine();
        while (!"Exhibition".equals(input)) {
            String[] elements = input.split(": ");
            String command = elements[0];
            String[] tokens = elements[1].split(" - ");
            String plant = tokens[0];
            if (!plants.containsKey(plant)) {
                System.out.println("error");
            } else {
                switch (command) {
                    case "Rate":
                        double rating = Double.parseDouble(tokens[1]);
                        plants.get(plant).addRating(rating);
                        break;
                    case "Update":
                        int newRarity = Integer.parseInt(tokens[1]);
                        plants.get(plant).setRarity(newRarity);
                        break;
                    case "Reset":
                        plants.get(plant).clearRatings();
                        break;
                    default:
                        System.out.println("error");
                        break;
                }
            }

            input = scanner.nextLine();
        }

        System.out.println("Plants for the exhibition:");
        plants.values()
                .stream()
                .sorted(Comparator
                        .comparing(Plant::getRarity)
                        .thenComparingDouble(Plant::getAverageRating)
                        .reversed())
                .map(Plant::toString)
                .forEach(System.out::println);
    }

    private static final class Plant {
        private final String name;
        private int rarity;
        private final List<Double> ratings;

        public Plant(String name, int rarity) {
            this.name = name;
            this.rarity = rarity;
            ratings = new ArrayList<>();
        }

        public void addRating(double rating) {
            ratings.add(rating);
        }

        public void setRarity(int newRarity) {
            rarity = newRarity;
        }

        public void clearRatings() {
            ratings.clear();
        }

        public int getRarity() {
            return rarity;
        }

        public String getName() {
            return name;
        }

        private double getAverageRating() {
            return ratings.stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElse(0.0);
        }

        @Override
        public String toString() {
            return String.format("- %s; Rarity: %d; Rating: %.2f",
                    name, rarity, getAverageRating());
        }
    }
}
