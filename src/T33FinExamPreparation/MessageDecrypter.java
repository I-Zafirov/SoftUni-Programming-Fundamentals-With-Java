package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageDecrypter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String regex = "^([$%])(?<name>[A-Z][a-z]{2,})\\1: \\[(?<num1>\\d+)\\]\\|\\[(?<num2>\\d+)\\]\\|\\[(?<num3>\\d+)\\]\\|$";
        Pattern pattern = Pattern.compile(regex);
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String name = matcher.group("name");
                char num1 = (char) Integer.parseInt(matcher.group("num1"));
                char num2 = (char) Integer.parseInt(matcher.group("num2"));
                char num3 = (char) Integer.parseInt(matcher.group("num3"));
                System.out.printf("%s: %c%c%c\n", name, num1, num2, num3);
            } else {
                System.out.println("Valid message not found!");
            }
        }

    }
}
