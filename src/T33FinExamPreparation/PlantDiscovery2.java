package T33FinExamPreparation;

import java.util.*;

public class PlantDiscovery2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        HashMap<String, Integer> rarityPlants = new HashMap<>();
        HashMap<String, List<Double>> ratingPlants = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("<->");
            String namePlant = tokens[0];
            int rarity = Integer.parseInt(tokens[1]);

            Integer currentRarity = rarityPlants.get(namePlant);
            if (currentRarity == null) {
                currentRarity = 0;
            }
            rarityPlants.put(namePlant, currentRarity + rarity);
            ratingPlants.putIfAbsent(namePlant, new ArrayList<>());
        }

        while (true) {
            String[] input = scanner.nextLine().split(": ");
            String command = input[0];
            if ("Exhibition".equals(command)) {
                break;
            }
            String[] tokens = input[1].split(" - ");
            String namePlant = tokens[0];
            if (!rarityPlants.containsKey(namePlant)) {
                System.out.println("error");
                continue;
            }
            switch (command) {
                case "Rate":
                    double rating = Double.parseDouble(tokens[1]);
                    ratingPlants.get(namePlant).add(rating);
                    break;
                case "Update":
                    int newRarity = Integer.parseInt(tokens[1]);
                    rarityPlants.put(namePlant, newRarity);
                    break;
                case "Reset":
                    ratingPlants.get(namePlant).clear();
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        }

        Map<String, Double> averageRating = new LinkedHashMap<>();

        for (Map.Entry<String, List<Double>> entry : ratingPlants.entrySet()) {
            double average = entry.getValue()
                    .stream()
                    .mapToDouble(x -> x)
                    .average()
                    .orElse(0.0);

            averageRating.put(entry.getKey(), average);
        }

        System.out.println("Plants for the exhibition:");
        rarityPlants.entrySet()
                .stream()
                .sorted((f, s) -> {
                    int result = s.getValue().compareTo(f.getValue());
                    if (result == 0) {
                        averageRating.entrySet().stream()
                                .sorted((g1, g2) -> g2.getValue().compareTo(g1.getValue()));
                    }
                    return result;
                }).forEach(entry -> System.out.printf("- %s; Rarity: %d; Rating: %.2f%n",
                        entry.getKey(),
                        entry.getValue(),
                        averageRating.get(entry.getKey())));
    }
}
