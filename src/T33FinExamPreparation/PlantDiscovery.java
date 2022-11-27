package T33FinExamPreparation;

import java.util.*;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        HashMap<String, Integer> plants = new HashMap<>();
        HashMap<String, List<Double>> ratedPlants = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("<->");
            String namePlant = tokens[0];
            int rarity = Integer.parseInt(tokens[1]);

            Integer currentRarity = plants.get(namePlant);
            if (currentRarity == null) {
                currentRarity = 0;
            }
            plants.put(namePlant, currentRarity + rarity);
            ratedPlants.putIfAbsent(namePlant, new ArrayList<>());
        }

        while (true) {
            String[] input = scanner.nextLine().split(": ");
            String command = input[0];
            if ("Exhibition".equals(command)) {
                break;
            }
            String[] tokens = input[1].split(" - ");
            String namePlant = tokens[0];
            if (!plants.containsKey(namePlant)) {
                System.out.println("error");
                continue;
            }
            switch (command) {
                case "Rate":
                    double rating = Double.parseDouble(tokens[1]);
                    ratedPlants.get(namePlant).add(rating);
                    break;
                case "Update":
                    int newRarity = Integer.parseInt(tokens[1]);
                    plants.put(namePlant, newRarity);
                    break;
                case "Reset":
                    ratedPlants.get(namePlant).clear();
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        }
        System.out.println("Plants for the exhibition:");
        plants.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().thenComparingDouble(x -> ratedPlants.get(x.getKey())
                                .stream()
                                .mapToDouble(Double::doubleValue)
                                .average()
                                .orElse(0.0))
                        .reversed())
                .forEach(entry -> System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", entry.getKey(), entry.getValue(),
                        ratedPlants.get(entry.getKey())
                                .stream()
                                .mapToDouble(Double::doubleValue)
                                .average()
                                .orElse(0.0)));
    }
}
