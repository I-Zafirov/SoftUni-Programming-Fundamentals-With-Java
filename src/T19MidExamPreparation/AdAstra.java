package T19MidExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        Pattern pattern = Pattern
                .compile("([#|])(?<itemName>[A-Za-z\\s]+)\\1(?<expirationDate>\\d{2}\\/\\d{2}\\/\\d{2})\\1(?<calories>\\d{1,5})\\1");
        Matcher match = pattern.matcher(input);
        Matcher match2 = pattern.matcher(input);

        int caloriesPerDay = 0;
        while (match.find()){
            String calories = match.group("calories");

            int caloriesInNumbers = Integer.parseInt(calories);
            caloriesPerDay += caloriesInNumbers;
        }
        System.out.println("You have food to last you for: " + caloriesPerDay / 2000 + " days!");

        while (match2.find()) {
            String itemName = match2.group("itemName");
            String expirationDate = match2.group("expirationDate");
            String calories = match2.group("calories");

            System.out.printf("Item: %s, Best before: %s, Nutrition: %s\n", itemName, expirationDate, calories);
        }
    }
}

