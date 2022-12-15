package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidMessageNotFound2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Pattern pattern = Pattern.compile("([*@])(?<tag>[A-Z][a-z]{2,})(\\1): \\[(?<string1>[A-Za-z])\\]\\|\\[(?<string2>[A-Za-z])\\]\\|\\[(?<string3>[A-Za-z])\\]\\|$");

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String tag = matcher.group("tag");
                String string1 = matcher.group("string1");
                String string2 = matcher.group("string2");
                String string3 = matcher.group("string3");

                System.out.println(String.format("%s: %s %s %s"
                        , tag, (int) string1.charAt(0), (int) string2.charAt(0), (int) string3.charAt(0)));
            } else {
                System.out.println("Valid message not found!");
            }

        }
    }
}
