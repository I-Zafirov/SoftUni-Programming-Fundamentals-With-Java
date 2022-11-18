package T33FinExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class NikuldensMeals2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, List<String>> guestsAndMeal = new TreeMap<>();
        String input = scanner.nextLine();
        int countUnlikeMeals = 0;
        while (!input.equals("Stop")) {
            String[] tokens = input.split("-");
            String command = tokens[0];
            switch (command) {
                case "Like": {
                    String guestName = tokens[1];
                    String meal = tokens[2];
                    if (!guestsAndMeal.containsKey(guestName)) {
                        guestsAndMeal.put(guestName, new ArrayList<>());
                        guestsAndMeal.get(guestName).add(meal);
                    } else {
                        if (!guestsAndMeal.get(guestName).contains(meal)) {
                            guestsAndMeal.get(guestName).add(meal);
                        }
                    }
                }
                break;
                case "Unlike": {
                    String guestName = tokens[1];
                    String meal = tokens[2];
                    if (!guestsAndMeal.containsKey(guestName)) {
                        System.out.printf("%s is not at the party.%n", guestName);
                    } else {
                        if (guestsAndMeal.get(guestName).contains(meal)) {
                            guestsAndMeal.get(guestName).remove(meal);
                            System.out.printf("%s doesn't like the %s.%n", guestName, meal);
                            countUnlikeMeals++;
                        } else {
                            System.out.printf("%s doesn't have the %s in his/her collection.%n", guestName, meal);
                        }
                    }
                }
                break;
            }
            input = scanner.nextLine();
        }
        guestsAndMeal.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().size() - a.getValue().size())
                .forEach(entry -> {
                    System.out.printf("%s: ", entry.getKey());
                    System.out.printf(String.join(", ", entry.getValue()));
                    System.out.println();
                });
        System.out.printf("Unliked meals: %d", countUnlikeMeals);
    }
}
