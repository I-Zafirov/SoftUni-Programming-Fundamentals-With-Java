package T33FinExamPreparation;

import java.util.*;

public class RarityRatingPlantsForTheExhibitionExhibition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> plants = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("<->");
            String plant = tokens[0];
            double rarity = Double.parseDouble(tokens[1]);
            if (plants.containsKey(plant)) {
                plants.get(plant).remove(0);
                plants.get(plant).add(0, rarity);
                plants.get(plant).add(1, 0.0);
            } else {
                plants.put(plant, new ArrayList<>());
                plants.get(plant).add(0, rarity);
                plants.get(plant).add(1, 0.0);
            }
        }
        String command = scanner.nextLine();
        while (!"Exhibition".equals(command)) {
            String[] tokens = command.split(":\\s+");
            String[] input = tokens[1].split("\\s+-\\s+");
            String inputPlant = input[0];
            if (plants.containsKey(inputPlant)) {
                switch (tokens[0]) {
                    case "Rate":
                        double rating = Double.parseDouble(input[1]);
                        double old = plants.get(inputPlant).remove(1);
                        if (old != 0) {
                            double newRating = (old + rating) / 2;
                            plants.get(inputPlant).add(1, newRating);
                        } else {
                            plants.get(inputPlant).add(1, rating);
                        }
                        break;
                    case "Update":
                        double newRarity = Double.parseDouble(input[1]);
                        plants.get(inputPlant).remove(0);
                        plants.get(inputPlant).add(0, newRarity);
                        break;
                    case "Reset":
                        plants.get(inputPlant).remove(1);
                        plants.get(inputPlant).add(1, 0.0);
                        break;
                    default:
                        System.out.println("error");
                }
            } else {
                System.out.println("error");
            }
            command = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");
        plants.entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    int res = e2.getValue().get(0).compareTo(e1.getValue().get(0));
                    if (res == 0) {
                        res = e2.getValue().get(1).compareTo(e1.getValue().get(1));
                    }
                    return res;
                })
                .forEach(element -> {
                    System.out.println(String.format("- %s; Rarity: %.0f; Rating: %.2f",
                            element.getKey(), element.getValue().get(0), element.getValue().get(1)));
                });
    }
}
