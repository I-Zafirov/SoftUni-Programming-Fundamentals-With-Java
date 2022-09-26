package T33FinExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstraList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern pattern = Pattern
                .compile("([|#])(?<name>[A-Za-z\\s]+)\\1(?<date>\\d{2}/\\d{2}/\\d{2})\\1(?<calories>\\d{1,5})\\1");
        Matcher matcher = pattern.matcher(text);

        List<String> itemsByExpDateAndCalories = new ArrayList<>();

        int totalCalories = 0;
        while (matcher.find()) {
            totalCalories += Integer.parseInt(matcher.group("calories"));
            itemsByExpDateAndCalories.add(matcher.group("name"));
            itemsByExpDateAndCalories.add(matcher.group("date"));
            itemsByExpDateAndCalories.add(matcher.group("calories"));
        }
        int days = totalCalories / 2000;

        System.out.printf("You have food to last you for: %d days!%n", days);
        for (int i = 0; i < itemsByExpDateAndCalories.size(); i += 3) {
            System.out.printf("Item: %s, Best before: %s, Nutrition: %s%n",
                    itemsByExpDateAndCalories.get(i),
                    itemsByExpDateAndCalories.get(i + 1),
                    itemsByExpDateAndCalories.get(i + 2));
        }
    }
}
