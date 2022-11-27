package T33FinExamPreparation;

import java.util.*;

public class PlantDiscovery3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> plantRarity = new HashMap<>();
        Map<String, List<Double>> plantRating = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("<->");
            String plantType = data[0];
            int rarity = Integer.parseInt(data[1]);
            plantRarity.put(plantType, rarity);
            plantRating.putIfAbsent(plantType, new ArrayList<>());
        }

        String input = scanner.nextLine();
        while (!input.equals("Exhibition")) {
            String[] data = input.split(": | - ");
            String command = data[0];
            String plantType = data[1];

            switch (command) {
                case "Rate":
                    double rating = Double.parseDouble(data[2]);
                    if (plantRating.containsKey(plantType)) {
                        List<Double> ratingList = new ArrayList<>();
                        plantRating.get(plantType).add(rating);

                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Update":
                    int newRarity = Integer.parseInt(data[2]);
                    if (plantRarity.containsKey(plantType)) {
                        plantRarity.put(plantType, newRarity);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Reset":
                    if (plantRating.containsKey(plantType)) {
                        plantRating.put(plantType, new ArrayList<>());
                    } else {
                        System.out.println("error");
                    }
                    break;
            }
            input = scanner.nextLine();
        }

        System.out.println("Plants for the exhibition:");
        plantRarity.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .forEach(a -> System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", a.getKey(), a.getValue(),
                        plantRating.get(a.getKey())
                                .stream()
                                .sorted((c, d) -> d.compareTo(c))
                                .mapToDouble(Double::doubleValue)
                                .average().orElse(0.00)));
    }
}
