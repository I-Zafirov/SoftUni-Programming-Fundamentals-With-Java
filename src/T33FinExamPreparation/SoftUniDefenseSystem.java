package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniDefenseSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pattern patt = Pattern.compile("([A-Z][a-z]+).*?([A-Z][a-z]*[A-Z]).*?(\\d+)L");

        int totalLiters = 0;
        String input = sc.nextLine();
        while (!input.equals("OK KoftiShans")) {
            Matcher matcher = patt.matcher(input);

            while (matcher.find()) {
                String guest = matcher.group(1);
                String drink = matcher.group(2).toLowerCase();
                String amount = matcher.group(3);
                totalLiters += Integer.parseInt(amount);
                System.out.printf("%s brought %s liters of %s!%n", guest, amount, drink);
            }
            input = sc.nextLine();
        }
        System.out.printf("%.3f softuni liters", (double) totalLiters / 1000);
    }
}
