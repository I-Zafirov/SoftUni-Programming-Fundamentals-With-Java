package T33FinExamPreparation;

import java.util.*;

public class UnlikedMealsIsNotAtTheParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> guestsAndMeals = new LinkedHashMap<>();
        int unlikedMeals = 0;

        String line = scanner.nextLine();
        while (!"Stop".equals(line)) {
            String[] infoGuest = line.split("-");
            String guestName = infoGuest[1];
            String mealName = infoGuest[2];
            switch (infoGuest[0]) {
                case "Like":
                    guestsAndMeals.putIfAbsent(guestName, new ArrayList<>());
                    List<String> mealsByGuest = guestsAndMeals.get(guestName);
                    if (!mealsByGuest.contains(mealName)) {
                        mealsByGuest.add(mealName);
                    }
                    guestsAndMeals.put(guestName, mealsByGuest);
                    break;
                case "Unlike":
                    if (!guestsAndMeals.containsKey(guestName)) {
                        System.out.println(String.format("%s is not at the party.", guestName));
                    } else {
                        List<String> meals = guestsAndMeals.get(guestName);
                        if (!meals.contains(mealName)) {
                            System.out.println(String.format("%s doesn't have the %s in his/her collection.", guestName, mealName));
                        } else {
                            unlikedMeals++;
                            meals.remove(mealName);
                            System.out.println(String.format("%s doesn't like the %s.", guestName, mealName));
                            guestsAndMeals.put(guestName, meals);
                        }
                    }

                    break;
            }
            line = scanner.nextLine();
        }

        guestsAndMeals.entrySet().stream()
                .sorted((a, b) -> {
                    int result = b.getValue().size() - a.getValue().size();
                    if (result == 0) {
                        return a.getKey().compareTo(b.getKey());
                    } else {
                        return result;
                    }
                }).forEach(g -> System.out.println(g.getKey() + ": " + print(g.getValue())));

        System.out.println(String.format("Unliked meals: %d", unlikedMeals));

    }

    private static String print(List<String> value) {
        return value.toString().replaceAll("[\\[\\]]", "");
    }
}
