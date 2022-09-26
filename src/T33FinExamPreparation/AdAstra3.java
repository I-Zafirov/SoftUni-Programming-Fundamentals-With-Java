package T33FinExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputText = scanner.nextLine();
        String regex = "(\\||#)(?<itemName>[A-Za-z\\s]+)\\1(?<expirationDate>\\d{2}\\/\\d{2}\\/\\d{2})\\1(?<calories>\\d{1,5})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputText);

        int sumCalories = 0;
        int lastOfDays = 0;
        List<List<String>> items = new ArrayList<>();
        while (matcher.find()) {
            String itemName = matcher.group("itemName");
            String dateOfExpire = matcher.group("expirationDate");
            int calories = Integer.parseInt(matcher.group("calories"));
            items.add(List.of(itemName, dateOfExpire, matcher.group("calories")));
            sumCalories += calories;
            lastOfDays = sumCalories / 2000;
        }
        String itemName = "";
        String expireDate = "";
        String calories = "";

        System.out.printf("You have food to last you for: %d days!%n", lastOfDays);
        for (List<String> item : items) {
            for (int i = 0; i < item.size(); i++) {
                itemName = item.get(0);
                expireDate = item.get(1);
                calories = item.get(2);
            }
            System.out.printf("Item: %s, Best before: %s, Nutrition: %s%n", itemName, expireDate, calories);
        }
    }
}

