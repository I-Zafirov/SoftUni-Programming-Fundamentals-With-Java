package T33FinExamPreparation;

import java.util.*;

public class Meals2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> likedMeals = new TreeMap<>();
        String line = scan.nextLine();
        int unliked = 0;
        while (!line.equals("Stop")) {
            String[] split = line.split("-");
            String type = split[0];
            String guestName = split[1];
            String mealName = split[2];
            if (type.equals("Like")) {
                List<String> guestMeals = likedMeals.get(guestName);
                if (guestMeals == null) {
                    guestMeals = new ArrayList<>();
                }
                if (!guestMeals.contains(mealName)) {
                    guestMeals.add(mealName);
                }
                likedMeals.put(guestName, guestMeals);
            } else if (type.equals("Unlike")) {
                if (!likedMeals.containsKey(guestName)) {
                    System.out.println(guestName + " is not at the party.");
                } else {
                    List<String> meals = likedMeals.get(guestName);

                    if (!meals.contains(mealName)) {
                        System.out.printf("%s doesn't have the %s in his/her collection.%n", guestName, mealName);
                    } else {
                        unliked++;
                        meals.remove(mealName);
                        System.out.printf("%s doesn't like the %s.%n", guestName, mealName);
                        likedMeals.put(guestName, meals);
                    }
                }
            }
            line = scan.nextLine();
        }
        likedMeals.entrySet().stream().sorted((l, r) -> r.getValue().size() - l.getValue().size())
                .forEach((e) -> System.out.println(e.getKey() + ": " + printList(e.getValue())));

        System.out.println("Unliked meals: " + unliked);
    }

    private static String printList(List<String> value) {
        return value.toString().replaceAll("[\\[\\]]", "");
    }
}
