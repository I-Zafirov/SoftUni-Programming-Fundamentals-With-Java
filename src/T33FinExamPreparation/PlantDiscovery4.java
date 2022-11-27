package T33FinExamPreparation;

import java.util.*;

public class PlantDiscovery4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberPlants = Integer.parseInt(scanner.nextLine());
        Map<String, PlantData> mapPlants = new LinkedHashMap<>();
        for (int i = 0; i < numberPlants; i++) {
            String[] currentRarity = scanner.nextLine().split("<->");
            String namePlant = currentRarity[0];
            int rarity = Integer.parseInt(currentRarity[1]);
            PlantData currentData = new PlantData(new ArrayList<>(), rarity);
            mapPlants.put(namePlant, currentData);
        }
        String command = scanner.nextLine();
        while (!command.equals("Exhibition")) {
            String[] commandLine = command.split(": | - ");
            String currentCommand = commandLine[0];
            String currentNamePlant = commandLine[1];
            if (!mapPlants.containsKey(currentNamePlant)) {
                System.out.println("error");
                command = scanner.nextLine();
                continue;
            }
            switch (currentCommand) {
                case "Rate":
                    int rating = Integer.parseInt(commandLine[2]);
                    mapPlants.get(currentNamePlant).addRating(rating);
                    break;
                case "Update":
                    int newRarity = Integer.parseInt(commandLine[2]);
                    mapPlants.get(currentNamePlant).setRarity(newRarity);
                    break;
                case "Reset":
                    mapPlants.get(currentNamePlant).removeAllRatings();
                    break;
                default:
                    System.out.println("error");
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");
        mapPlants.entrySet().stream().sorted((e1, e2) -> {
            int result = Integer.compare(e2.getValue().getRarity(), e1.getValue().getRarity());
            if (result == 0) {
                result = Double.compare(e2.getValue().getAverageRating()
                        , e1.getValue().getAverageRating());
            }
            return result;
        }).forEach(e -> System.out.printf("- %s; Rarity: %d; Rating: %.2f\n", e.getKey()
                , e.getValue().getRarity(), e.getValue().getAverageRating()));
    }

    static class PlantData {
        private List<Integer> listRating;
        private int rarity;

        public PlantData(List<Integer> listRating, int rarity) {
            this.listRating = listRating;
            this.rarity = rarity;
        }

        public void setListRating(List<Integer> listRating) {
            this.listRating = listRating;
        }

        public void setRarity(int rarity) {
            this.rarity = rarity;
        }

        public List<Integer> getListRating() {
            return listRating;
        }

        public int getRarity() {
            return rarity;
        }

        public void addRating(int rating) {
            this.listRating.add(rating);
        }

        public void removeAllRatings() {
            listRating.clear();
        }

        public double getAverageRating() {
            double sum = 0.0;
            for (var e : listRating) {
                sum += e;
            }
            if (sum == 0) {
                return 0;
            } else {
                return sum / listRating.size();
            }
        }
    }
}

