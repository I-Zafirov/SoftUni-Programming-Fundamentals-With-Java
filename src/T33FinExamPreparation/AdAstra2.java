package T33FinExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "([#|\\/])(?<itemName>[A-Za-z ]+)\\1" +
                "(?<expDate>\\d{2}\\/\\d{2}\\/\\d{2})\\1(?<calories>\\d+)\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        List<String> listItems = new ArrayList<>();
        int totalCalories = 0;
        while (matcher.find()) {
            String currentItem = "Item: " + matcher.group("itemName") + ", Best before: "
                    + matcher.group("expDate") + ", Nutrition: " + matcher.group("calories");
            listItems.add(currentItem);
            totalCalories += Integer.parseInt(matcher.group("calories"));
        }
        int days = totalCalories / 2000;
        System.out.printf("You have food to last you for: %d days!\n", days);
        listItems.forEach(e -> System.out.println(e));
    }
}
