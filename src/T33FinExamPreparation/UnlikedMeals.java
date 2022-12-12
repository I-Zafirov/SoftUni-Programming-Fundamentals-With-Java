package T33FinExamPreparation;

import java.util.*;

public class UnlikedMeals {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        Map<String, List<String>> guests = new TreeMap<>();
        int unlikedMeals = 0;

        while (!"Stop".equals(input)) {
            String[] tokens = input.split("-");
            String command = tokens[0];
            String name = tokens[1];
            String meal = tokens[2];
            switch (command) {
                case "Like":
                    guests.putIfAbsent(name, new ArrayList<>());
                    List<String> list = guests.get(name);
                    list.add(meal);
                    break;
                case "Unlike":
                    if (!guests.containsKey(name)) {
                        System.out.printf("%s is not at the party.%n", name);
                        break;
                    }
                    list = guests.get(name);
                    if (!list.contains(meal)) {
                        System.out.printf("%s doesn't have the %s in his/her collection.%n", name, meal);
                        break;
                    } else {
                        list.remove(meal);
                        guests.put(name, list);
                        System.out.printf("%s doesn't like the %s.%n", name, meal);
                        unlikedMeals++;
                    }

                    break;
            }

            input = scan.nextLine();
        }
        guests
                .entrySet()
                .stream()
                .sorted((m1, m2) -> Integer.compare(m2.getValue().size(), m1.getValue().size()))
                .forEach(entry -> {
                    if (entry.getValue().isEmpty()) {
                        System.out.print(entry.getKey() + ":");
                        entry.getValue().forEach(m -> System.out.print(m + ","));
                        System.out.println();
                    } else {
                        System.out.printf("%s: %s%n", entry.getKey(),
                                entry.getValue()
                                        .toString()
                                        .replaceAll("[\\]\\[]", ""))
                        ;
                    }
                });
        System.out.println("Unliked meals: " + unlikedMeals);

    }
}
