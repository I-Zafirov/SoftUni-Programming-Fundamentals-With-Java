package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageEncrypter2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String regex = "(\\*|@)(?<tag>[A-Z][a-z]{2,})\\1: \\[(?<first>[A-Za-z])\\]\\|" +
                "\\[(?<second>[A-Za-z])\\]\\|\\[(?<third>[A-Za-z])\\]\\|$";
        Pattern pattern = Pattern.compile(regex);
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String tag = matcher.group("tag");
                char first = matcher.group("first").charAt(0);
                char second = matcher.group("second").charAt(0);
                char third = matcher.group("third").charAt(0);

                System.out.printf("%s: ", tag);
                System.out.printf("%d ", (int) first);
                System.out.printf("%d ", (int) second);
                System.out.printf("%d", (int) third);
                System.out.println();
            } else {
                System.out.println("Valid message not found!");
            }
        }
    }
}
