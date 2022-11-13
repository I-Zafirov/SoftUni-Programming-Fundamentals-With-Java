package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageEncrypter22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int linesToRead = Integer.parseInt(scanner.nextLine());
        Pattern pattern = Pattern.compile("^([%$])(?<name>[A-Z][a-z]{3,})\\1: \\[(?<str1>\\d+)\\]\\|\\[(?<str2>\\d+)\\]\\|\\[(?<str3>\\d+)\\]\\|$");

        for (int i = 0; i < linesToRead; i++) {
            String message = scanner.nextLine();

            Matcher matcher = pattern.matcher(message);
            if (matcher.find()) {
                String name = matcher.group("name");
                int str1 = Integer.parseInt(matcher.group("str1"));
                int str2 = Integer.parseInt(matcher.group("str2"));
                int str3 = Integer.parseInt(matcher.group("str3"));

                System.out.println(String.format("%s: %s%s%s", name, (char) str1, (char) str2, (char) str3));
            } else {
                System.out.println("Valid message not found!");
            }
        }
    }
}
