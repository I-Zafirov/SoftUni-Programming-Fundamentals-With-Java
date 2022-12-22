package T37PracticalExam;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P3WildZoo {
    static class Feeding {
        private int food;
        private String area;

        public Feeding(int food, String area) {
            this.food = food;
            this.area = area;
        }

        public String getArea() {
            return this.area;
        }

        public int getFood() {
            return this.food;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Map<String, Integer> areas = new LinkedHashMap<>();
        Map<String, Feeding> animal = new LinkedHashMap<>();
        while (!command.equals("EndDay")) {
            String[] data = command.split(": |\\-");
            String AddOrFeed = data[0];
            String name = data[1];
            int food = Integer.parseInt(data[2]);
            switch (AddOrFeed) {
                case "Add":
                    String area = data[3];
                    if (animal.containsKey(name)) {
                        animal.put(name, new Feeding(animal.get(name).getFood() + food, area));
                    } else {
                        animal.put(name, new Feeding(food, area));
                        if (areas.containsKey(area)) {
                            areas.put(area, areas.get(area) + 1);
                        } else {
                            areas.put(area, 1);
                        }
                    }
                    break;
                case "Feed":
                    if (animal.containsKey(name)) {
                        animal.put(name, new Feeding(animal.get(name).getFood() - food, animal.get(name).getArea()));
                        if (animal.get(name).getFood() <= 0) {
                            System.out.println(name + " was successfully fed");
                            String region = animal.get(name).getArea();
                            areas.put(region, areas.get(region) - 1);
                            animal.remove(name);
                            if (areas.get(region) <= 0) {
                                areas.remove(region);
                            }
                        }
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println("Animals: ");
        animal.entrySet().stream()
                .forEach(e -> System.out.println(" " + e.getKey() + " -> " + e.getValue().getFood() + "g"));
        System.out.println("Areas with hungry animals: ");
        areas.entrySet().stream()
                .forEach(e -> System.out.println(" " + e.getKey() + ": " + e.getValue()));
    }
}


