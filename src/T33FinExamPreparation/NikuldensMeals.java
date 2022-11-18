package T33FinExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class NikuldensMeals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> guests = new HashMap<>();
        List<String> meals = new ArrayList<>();
        int unlike = 0;
        String input;
        while (!"Stop".equals(input = scanner.nextLine())) {
            String[] tokens = input.split("-");
            String guest = tokens[1];
            String meal = tokens[2];
            switch (tokens[0]) {
                case "Like":
                    if (!guests.containsKey(guest)) {
                        List<String> newList = new ArrayList<>();
                        newList.add(meal);
                        guests.put(guest, newList);
                    } else {
                        if (!guests.get(guest).contains(meal)) {
                            meals = guests.get(guest);
                            meals.add(meal);
                            guests.put(guest, meals);
                        }
                    }
                    break;
                case "Unlike":
                    if (!guests.containsKey(guest)) {
                        System.out.printf("%s is not at the party.\n", guest);
                    } else {
                        meals = guests.get(guest);
                        if (!meals.contains(meal)) {
                            System.out.printf("%s doesn't have the %s in his/her collection.\n", guest, meal);
                        } else {
                            meals.remove(meal);
                            unlike++;
                            guests.put(guest, meals);
                            System.out.printf("%s doesn't like the %s.\n", guest, meal);
                        }
                    }
                    break;
            }
        }
        List<String> names = guests
                .entrySet().stream()
                .sorted((a, b) -> b.getValue().size() - a.getValue().size())
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
        for (String name : names) {
            System.out.printf("%s: ", name);
            for (int i = 0; i < guests.get(name).size(); i++) {
                System.out.printf("%s", guests.get(name).get(i));
                if (i != guests.get(name).size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
        System.out.printf("Unliked meals: %d", unlike);
    }
}
