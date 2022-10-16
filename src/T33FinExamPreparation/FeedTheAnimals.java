package T33FinExamPreparation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FeedTheAnimals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> animal = new LinkedHashMap<>();
        Map<String, Integer> areas = new LinkedHashMap<>();
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("Last Info")) {
                break;
            }
            String[] part = line.split(": ");
            String command = part[0];
            String name = part[1];
            String area = part[3];
            int food = Integer.parseInt(part[2]);
            if (command.equals("Add")) {
                if (animal.containsKey(name)) {
                    animal.put(name, animal.get(name) + food);
                } else {
                    animal.put(name, food);
                    if (areas.containsKey(area)) {
                        areas.put(area, areas.get(area) + 1);
                    } else {
                        areas.put(area, 1);
                    }
                }
            } else {
                if (animal.containsKey(name)) {
                    int newFood = animal.get(name) - food;
                    if (newFood > 0) {
                        animal.put(name, newFood);
                    } else {
                        animal.remove(name);
                        System.out.printf("%s was successfully fed%n", name);
                        if (areas.containsKey(area)) {
                            areas.put(area, areas.get(area) - 1);
                        }
                    }
                }

            }


        }
        System.out.println("Animals:");
        animal.entrySet().stream()
                .sorted((e1, e2) -> {
                    int sort = e2.getValue().compareTo(e1.getValue());
                    if (sort == 0) {
                        sort = e1.getKey().compareTo(e2.getKey());
                    }
                    return sort;
                })
                .forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue() + "g"));
        System.out.println("Areas with hungry animals:");
        areas.entrySet().stream()
                .filter(e -> e.getValue() > 0)
                .sorted((f, s) -> s.getValue().compareTo(f.getValue()))
                .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
    }
}
