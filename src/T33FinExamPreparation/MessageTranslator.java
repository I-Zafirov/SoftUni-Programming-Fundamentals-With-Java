package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String regex = "!(?<command>[A-Z][a-z]{2,})!:\\[(?<message>[A-Za-z]{8,})\\]";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String command = matcher.group("command");
                String message = matcher.group("message");
                System.out.printf("%s: ", command);
                for (int j = 0; j < message.length(); j++) {
                    int currentChar = message.charAt(j);
                    if ((j) == (message.length() - 1)) {
                        System.out.print(currentChar);
                    } else {
                        System.out.print(currentChar + " ");
                    }
                }
                System.out.println();
            } else {
                System.out.println("The message is invalid");
            }
        }
        System.out.println();
    }
}
