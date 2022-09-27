package T33FinExamPreparation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AreasWithHungryAnimalsWasSuccessfullyFedLastInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> unfedAnimals = new LinkedHashMap<>();

        String line = scanner.nextLine();
        while (!"Last Info".equals(line)) {
            String[] info = line.split(":");
            if (info[0].equals("Add")) {
                unfedAnimals.putIfAbsent(info[3], new LinkedHashMap<>());
                unfedAnimals.get(info[3]).putIfAbsent(info[1], 0);
                unfedAnimals.get(info[3]).put(info[1], unfedAnimals.get(info[3]).get(info[1]) + Integer.parseInt(info[2]));
            } else if (info[0].equals("Feed")) {
                if (unfedAnimals.containsKey(info[3])) {
                    if (unfedAnimals.get(info[3]).containsKey(info[1])) {
                        unfedAnimals.get(info[3]).put(info[1], unfedAnimals.get(info[3]).get(info[1]) - Integer.parseInt(info[2]));
                        if (unfedAnimals.get(info[3]).get(info[1]) <= 0) {
                            unfedAnimals.get(info[3]).remove(info[1]);
                            if (unfedAnimals.get(info[3]).size() == 0) {
                                unfedAnimals.remove(info[3]);
                            }
                            System.out.println(String.format("%s was successfully fed", info[1]));
                        }
                    }
                }
            }
        }
        Map<String, Integer> animals = new LinkedHashMap<>();
        for (Map.Entry<String, Map<String, Integer>> entry : unfedAnimals.entrySet()) {
            for (Map.Entry<String, Integer> item : entry.getValue().entrySet()) {
                animals.put(item.getKey(), item.getValue());
            }
        }
        System.out.println("Animals:");
        animals.entrySet().stream().sorted((a, b) -> {
                    int sort = Integer.compare(b.getValue(), a.getValue());
                    if (sort == 0) {
                        sort = a.getKey().compareTo(b.getKey());
                    }
                    return sort;
                })
                .forEach(e -> System.out.println(String.format("%s -> %dg", e.getKey(), e.getValue())));
        System.out.println("Areas with hungry animals:");
        unfedAnimals.entrySet().stream().sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .forEach(e -> {
                    System.out.println(String.format("%s : %d", e.getKey(), e.getValue().size()));
                });
    }
}
