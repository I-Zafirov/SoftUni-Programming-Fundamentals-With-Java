package T33FinExamPreparation;

import java.util.*;

public class PlantDiscoveryObject2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Plant> plantsByName = new HashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] nameAndRarity = scanner.nextLine().split("<->");
            Plant p = new Plant(nameAndRarity[0], Integer.parseInt(nameAndRarity[1]));
            plantsByName.put(p.getName(), p);
        }

        String command = scanner.nextLine();
        while (!"Exhibition".equals(command)) {
            String[] commandAndParameters = command.split(": ");

            switch (commandAndParameters[0]) {
                case "Rate":
                    String[] rateParameters = commandAndParameters[1].split(" - ");
                    String ratePlantName = rateParameters[0];
                    int rating = Integer.parseInt(rateParameters[1]);

                    Plant ratePlant = plantsByName.get(ratePlantName);
                    if (ratePlant != null) {
                        ratePlant.addRating(rating);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Update":
                    String[] updateParameters = commandAndParameters[1].split(" - ");
                    String updatePlantName = updateParameters[0];
                    int rarity = Integer.parseInt(updateParameters[1]);

                    Plant updatePlant = plantsByName.get(updatePlantName);
                    if (updatePlant != null) {
                        updatePlant.setRarity(rarity);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Reset":
                    String resetPlantName = commandAndParameters[1];
                    Plant resetPlant = plantsByName.get(resetPlantName);
                    if (resetPlant != null) {
                        resetPlant.clearRatings();
                    } else {
                        System.out.println("error");
                    }
                    break;
                default:
                    System.out.println("error");
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");
        plantsByName.values()
                .stream()
                .sorted((a, b) -> {
                    if (a.getRarity() != b.getRarity()) {
                        return Integer.compare(b.getRarity(), a.getRarity());
                    } else {
                        return Double.compare(b.getAverageRating(), a.getAverageRating());
                    }
                })
                .map(p -> "- " + p.getName() + "; Rarity: " + p.getRarity() + "; Rating: " + String.format("%.2f", p.getAverageRating()))
                .forEach(s -> System.out.println(s));

    }

    private static class Plant {
        private String name;
        int rarity;
        List<Double> ratings;

        // constructor without rating
        public Plant(String name, int rarity) {
            this.name = name;
            this.rarity = rarity;
            this.ratings = new ArrayList<>();
        }

        public int getRarity() {
            return rarity;
        }

        public String getName() {
            return name;
        }

        public void addRating(double rating) {
            this.ratings.add(rating);
        }

        public void setRarity(int rarity) {
            this.rarity = rarity;
        }

        public void clearRatings() {
            this.ratings.clear();
        }

        public double getAverageRating() {
            double averageRating = 0;
            if (this.ratings.isEmpty()) {
                return 0;
            }

            for (Double rating : this.ratings) {
                averageRating += rating;
            }
            averageRating = averageRating / this.ratings.size();
            return averageRating;
        }
    }
}
