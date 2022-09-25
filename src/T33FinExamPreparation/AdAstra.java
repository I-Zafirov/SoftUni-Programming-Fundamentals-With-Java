package T33FinExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        Pattern pattern = Pattern.compile("(\\||#)(?<itemName>[A-Za-z\\s]+)\\1(?<expirationDate>\\d{2}/\\d{2}/\\d{2})\\1(?<calories>\\d{1,5})\\1");
        Matcher matcher = pattern.matcher(text);

        List<String> items = new ArrayList<>();
        List<String> dates = new ArrayList<>();
        List<Integer> calories = new ArrayList<>();

        int totalCalories = 0;
        while (matcher.find()) {
            totalCalories += Integer.parseInt(matcher.group("calories"));
            items.add(matcher.group("itemName"));
            dates.add(matcher.group("expirationDate"));
            calories.add(Integer.parseInt(matcher.group("calories")));
        }
        int days = totalCalories / 2000;

        System.out.printf("You have food to last you for: %d days!%n", days);
        for (int i = 0; i < items.size(); i++) {
            System.out.printf("Item: %s, Best before: %s, Nutrition: %d%n",
                    items.get(i), dates.get(i), calories.get(i));
        }
    }
}
