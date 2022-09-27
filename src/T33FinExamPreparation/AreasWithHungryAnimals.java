package T33FinExamPreparation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AreasWithHungryAnimals {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        Map<String, Integer> mapy = new LinkedHashMap<>();
        Map<String, Zoo> map = new LinkedHashMap<>();

        while (!command.equals("EndDay")) {
            String[] com = command.split(": |\\-");
            String first = com[0];
            String name = com[1];
            int food = Integer.parseInt(com[2]);

            if (first.equals("Add")) {
                String region = com[3];
                if (map.containsKey(name)) {
                    map.put(name, new Zoo(map.get(name).getFood() + food, region));
                } else {
                    map.put(name, new Zoo(food, region));
                    if (mapy.containsKey(region)) {
                        mapy.put(region, mapy.get(region) + 1);
                    } else {
                        mapy.put(region, 1);
                    }
                }
            } else if (first.equals("Feed")) {
                if (map.containsKey(name)) {
                    map.put(name, new Zoo(map.get(name).getFood() - food, map.get(name).getRegion()));
                    if (map.get(name).getFood() <= 0) {
                        System.out.println(name + " was successfully fed");
                        String regionStr = map.get(name).getRegion();
                        mapy.put(regionStr, mapy.get(regionStr) - 1);
                        map.remove(name);

                        if (mapy.get(regionStr) <= 0) {
                            mapy.remove(regionStr);
                        }
                    }
                }
            }
            command = scanner.nextLine();
        }

        System.out.println("Animals: ");
        map.entrySet().stream().sorted((e1, e2) -> {
            int result = Integer.compare(e2.getValue().getFood(), e1.getValue().getFood());
            if (result == 0) {
                result = e1.getKey().compareTo(e2.getKey());
            }
            return result;
        }).forEach(e -> System.out.println(" " + e.getKey() + " -> " + e.getValue().getFood() + "g"));


        System.out.println("Areas with hungry animals: ");
        mapy.entrySet().stream().sorted((e1, e2) -> {
            int result = Integer.compare(e2.getValue(), e1.getValue());
            if (result == 0) {
                result = e1.getKey().compareTo(e2.getKey());
            }
            return result;
        }).forEach(e -> System.out.println(" " + e.getKey() + ": " + e.getValue()));
    }

    static class Zoo {
        private int food;
        private String region;

        public Zoo(int food, String region) {
            this.food = food;
            this.region = region;
        }

        public String getRegion() {
            return this.region;
        }

        public int getFood() {
            return this.food;
        }
    }
}

