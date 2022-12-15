package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidMessageNotFound {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String regex = "^(\\$|%)()(?<tag>[A-Z][a-z]{2,})\\1: (\\[)(?<firstGroup>\\d+)(\\])(\\|)\\4(?<secondGroup>\\d+)\\6\\7\\4(?<thirdGroup>\\d+)\\6\\7$";
        Pattern pattern = Pattern.compile(regex);
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String tag = matcher.group("tag");
                int firstGroup = Integer.parseInt(matcher.group("firstGroup"));
                int secondGroup = Integer.parseInt(matcher.group("secondGroup"));
                int thirdGroup = Integer.parseInt(matcher.group("thirdGroup"));
                String decryptedMessage = (char) firstGroup + "" + (char) (secondGroup) + "" + (char) (thirdGroup);
                System.out.printf("%s: %s%n", tag, decryptedMessage);
            } else {
                System.out.println("Valid message not found!");
            }
        }
    }
}
