package T19MidExamPreparation;

import java.util.*;

public class PlantDiscovery {
    static class Plant {
        String name;
        int rarity;
        List<Double> rating;

        public Plant(String name, int rarity) {
            this.name = name;
            this.rarity = rarity;
            this.rating = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public int getRarity() {
            return rarity;
        }

        public void setRarity(int rarity) {
            this.rarity = rarity;
        }

        public double getAverage() {
            double average = 0;
            if (this.rating.isEmpty()) {
                return 0;
            }
            for (Double rating : this.rating) {
                average += rating;
            }
            return average /= this.rating.size();
        }

        public void getRating(double rating) {
            this.rating.add(rating);
        }

        public void clearRatings() {
            this.rating.clear();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, Plant> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] nameAndRarity = scan.nextLine().split("<->");
            Plant plants = new Plant(nameAndRarity[0], Integer.parseInt(nameAndRarity[1]));

            map.put(plants.getName(), plants);
        }
        String[] commands = scan.nextLine().split(": | - ");

        while (!commands[0].equals("Exhibition")) {
            String plant = commands[1];

            switch (commands[0]) {
                case "Rate":
                    double rating = Double.parseDouble(commands[2]);
                    Plant plantsRating = map.get(plant);
                    if (plantsRating!=null) {
                        map.get(plant).getRating(rating);
                    }else{
                        System.out.println("error");
                        break;
                    }

                    map.get(plant).getRating(rating);
                    break;
                case "Update":
                    int rarity = Integer.parseInt(commands[2]);

                    Plant plantsUpdate = map.get(plant);
                    if (plantsUpdate!=null) {
                        map.get(plant).setRarity(rarity);
                    }else{
                        System.out.println("error");
                        break;
                    }
                    break;
                case "Reset":
                    Plant plantsReset = map.get(plant);
                    if (plantsReset!=null) {
                        map.get(plant).clearRatings();
                    }else{
                        System.out.println("error");
                        break;
                    }
                    break;
                default:
                    System.out.println("error");
                    break;
            }
            commands = scan.nextLine().split(": | - ");
        }
        System.out.println("Plants for the exhibition:");

        map.values().stream()
                .sorted((a, b) -> {
                    if (a.getRarity() != b.getRarity()) {
                        return Integer.compare(b.getRarity(), a.getRarity());
                    } else {
                        return Double.compare(b.getAverage(), a.getAverage());
                    }
                })
                .map(p -> String.format("- %s; Rarity: %d; Rating: %.2f", p.getName(), p.getRarity(), p.getAverage()))
                .forEach(e -> System.out.println(e));
    }
}
