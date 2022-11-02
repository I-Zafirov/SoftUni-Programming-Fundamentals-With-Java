package T33FinExamPreparation;

import java.util.*;

public class Meals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> likedMeals = new HashMap<>();

        String input = scanner.nextLine();
        int count = 0;
        while (!input.equals("Stop")) {
            String[] tokens = input.split("-");
            String command = tokens[0];
            String guest = tokens[1];
            String meal = tokens[2];

            switch (command) {
                case "Like":
                    if (!likedMeals.containsKey(guest)) {
                        likedMeals.put(guest, new ArrayList<>());
                        likedMeals.get(guest).add(meal);
                    } else {
                        if (!likedMeals.get(guest).contains(meal)) {
                            likedMeals.get(guest).add(meal);
                        }
                    }
                    break;
                case "Unlike":
                    if (!likedMeals.containsKey(guest)) {
                        System.out.printf("%s is not at the party.%n", guest);
                    } else {
                        if (!likedMeals.get(guest).contains(meal)) {
                            System.out.printf("%s doesn't have the %s in his/her collection.%n", guest, meal);
                        } else {
                            likedMeals.get(guest).remove(meal);
                            System.out.printf("%s doesn't like the %s.%n", guest, meal);
                            count++;
                        }
                    }
                    break;
            }
            input = scanner.nextLine();
        }

        likedMeals.entrySet()
                .stream()
                .sorted((a, b) -> {
                    int result = b.getValue().size() - a.getValue().size();
                    if (result == 0) {
                        result = a.getKey().compareTo(b.getKey());
                    }
                    return result;
                })
                .forEach(entry -> {
                    System.out.printf("%s: %s%n", entry.getKey(), String.join(", ", entry.getValue()));
                });
        System.out.printf("Unliked meals: %d%n", count);
    }
}

