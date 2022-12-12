package T33FinExamPreparation;

import java.util.*;

public class UnlikedMealsIsNotAtThePartyStopLikeUnlike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<String>> guestsAndMeals = new LinkedHashMap<>();
        int unlikedMeals = 0;
        while (!input.equals("Stop")) {
            String[] tokens = input.split("-");
            String command = tokens[0];
            String guest = tokens[1];
            String meal = tokens[2];
            switch (command) {
                case "Like":
                    if (!guestsAndMeals.containsKey(guest)) {
                        guestsAndMeals.put(guest, new ArrayList<>());
                    }
                    if (!guestsAndMeals.get(guest).contains(meal)) {
                        guestsAndMeals.get(guest).add(meal);
                    }
                    break;
                case "Unlike":
                    if (!guestsAndMeals.containsKey(guest)) {
                        System.out.printf("%s is not at the party.%n", guest);
                    } else {
                        if (guestsAndMeals.get(guest).contains(meal)) {
                            unlikedMeals++;
                            System.out.printf("%s doesn't like the %s.%n", guest, meal);
                            guestsAndMeals.get(guest).remove(meal);
                        } else {
                            System.out.printf("%s doesn't have the %s in his/her collection.%n", guest, meal);
                        }
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        guestsAndMeals.entrySet().stream().sorted((left, right) -> {
            if (right.getValue().size() - left.getValue().size() == 0) {
                return left.getKey().compareTo(right.getKey());
            } else {
                return right.getValue().size() - left.getValue().size();
            }
        }).forEach(guest -> {
            System.out.printf("%s: ", guest.getKey());
            System.out.println(String.join(", ", guest.getValue()));
        });
        System.out.printf("Unliked meals: %d", unlikedMeals);
    }
}
