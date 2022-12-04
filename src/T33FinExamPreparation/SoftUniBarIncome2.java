package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        double totalIncome = 0;
        Pattern pattern = Pattern.compile("%(?<name>[A-Z][a-z]+)%[^$|.]*?<(?<product>\\w+)>" +
                "[^$|.]*?\\|(?<count>\\d+)\\|[^$|.]*?(?<price>\\d+\\.*\\d+)\\$");
        String input;

        while (!"end of shift".equals(input = scanner.nextLine())) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {

                double totalPrice = Double.parseDouble(matcher.group("count"))
                        * Double.parseDouble(matcher.group("price"));
                totalIncome += totalPrice;

                System.out.println(String.format("%s: %s - %.2f"
                        , matcher.group("name"), matcher.group("product")
                        , totalPrice));
            }
        }
        System.out.println(String.format("Total income: %.2f", totalIncome));
    }
}
