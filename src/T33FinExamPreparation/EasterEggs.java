package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EasterEggs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "(@|#)+(?<color>[a-z][a-z][a-z]+)(@|#)+\\W*\\/(?<amount>[0-9]+)\\/+";
        String inputText = scanner.nextLine();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputText);

        while (matcher.find()) {
            String color = matcher.group("color");
            int amount = Integer.parseInt(matcher.group("amount"));

            System.out.printf("You found %d %s eggs!\n", amount, color);
        }
    }
}
