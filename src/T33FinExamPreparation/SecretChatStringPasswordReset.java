package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Pattern;

public class SecretChatStringPasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();
        String input = scanner.nextLine();
        while (!"Reveal".equals(input)) {
            String[] instructions = input.split(":\\|:");
            switch (instructions[0]) {
                case "InsertSpace": {
                    int startIndex = Integer.parseInt(instructions[1]);
                    String firstPart = message.substring(0, startIndex);
                    String secondPart = message.substring(startIndex);
                    message = firstPart + " " + secondPart;
                    System.out.println(message);
                }
                break;
                case "Reverse": {
                    String substring = instructions[1];
                    if (message.contains(substring)) {
                        int startIndex = message.indexOf(substring);
                        int endIndexExclusive = startIndex + substring.length();
                        StringBuilder reversed = new StringBuilder(message.substring(startIndex, endIndexExclusive)).reverse();
                        message = message.replaceFirst(Pattern.quote(substring), "") + reversed;
                        String firstPart = message.substring(0, startIndex);
                        String lastPart = message.substring(endIndexExclusive);
                        message = firstPart + lastPart;

                        message = message + reversed;

                        System.out.println(message);
                    } else {
                        System.out.println("error");
                    }
                }
                case "ReverseA": {
                    String substring = instructions[1];
                    if (message.contains(substring)) {
                        String reversed = new StringBuilder(substring).reverse().toString();
                        message = message.replaceFirst(Pattern.quote(substring), "") + reversed;
                        System.out.println(message);
                    } else {
                        System.out.println("error");
                    }
                    break;
                }
                case "ChangeAll": {
                    String substring = instructions[1];
                    String replacement = instructions[2];
                    message = message.replace(substring, replacement);
                    System.out.println(message);
                }
                break;
                default:
                    System.out.println("Invalid command: " + instructions[0]);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("You have a new text message: %s", message);
    }
}
