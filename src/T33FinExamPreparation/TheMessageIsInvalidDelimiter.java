package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheMessageIsInvalidDelimiter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        final String REGEX = "!(?<command>[A-Z][a-z]{3,})!(?<delimiter>:)\\[(?<message>[A-Za-z]{8,})\\]";
        Pattern pattern = Pattern.compile(REGEX);


        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            Matcher matcher = pattern.matcher(input);
            String command = "";
            String message = "";
            String delimiter = "";
            boolean isFInd = false;
            if (matcher.find()) {
                command = matcher.group("command");
                message = matcher.group("message");
                delimiter = matcher.group("delimiter");
                isFInd = true;
            } else {
                System.out.println("The message is invalid");
            }
            StringBuilder encrypt = new StringBuilder();
            for (int j = 0; j < message.length(); j++) {
                encrypt.append((int) message.charAt(j)).append(" ");
            }
            if (isFInd) {
                System.out.printf("%s%s %s%n", command, delimiter, encrypt.toString());
            }
        }
    }
}
