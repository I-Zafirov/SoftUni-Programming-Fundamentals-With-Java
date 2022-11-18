package T33FinExamPreparation;

import java.util.*;

public class NikuldenMeals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> likedMeals = new TreeMap<>();
        int disliked = 0;
        String command = scanner.nextLine();
        while (!command.equals("Stop")) {
            String[] commandParts = command.split("-");
            String taste = commandParts[0];
            String guest = commandParts[1];
            String meal = commandParts[2];
            if (taste.equals("Like")) {
                List<String> meals = likedMeals.get(guest);
                if (meals == null) {
                    meals = new ArrayList<>();
                }
                if (!meals.contains(meal)) {
                    meals.add(meal);
                }
                likedMeals.put(guest, meals);
            } else {
                if (!likedMeals.containsKey(guest)) {
                    System.out.printf("%s is not at the party.%n", guest);
                } else {
                    List<String> meals = likedMeals.get(guest);

                    if (!meals.contains(meal)) {
                        System.out.printf("%s doesn't have the %s in his/her collection.%n", guest, meal);
                    } else {
                        meals.remove(meal);
                        disliked++;
                        System.out.printf("%s doesn't like the %s.%n", guest, meal);
                        likedMeals.put(guest, meals);
                    }
                }
            }
            if (scanner.hasNextLine()) {
                command = scanner.nextLine();
            }
        }
        likedMeals.entrySet().stream()
                .sorted((l, r) -> r.getValue().size() - l.getValue().size())
                .forEach((e) -> System.out.println(e.getKey() + ": " + printList(e.getValue())));

        System.out.println("Unliked meals: " + disliked);
    }

    public static String printList(List<String> value) {
        return value.toString().replaceAll("[\\[\\]]", "");
    }
}
