package T33FinExamPreparation;

import java.util.Scanner;

public class SecretChatStringBuilderPasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder message = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();

        while (!"Reveal".equals(input)) {
            String[] instructions = input.split(":\\|:");
            switch (instructions[0]) {
                case "InsertSpace": {
                    int index = Integer.parseInt(instructions[1]);
                    message.insert(index, " ");
                    System.out.println(message);
                }
                break;
                case "Reverse": {
                    String substring = instructions[1];
                    if (message.toString().contains(substring)) {
                        int startIndex = message.indexOf(substring);
                        int endIndexExclusive = startIndex + substring.length();
                        StringBuilder reversed = new StringBuilder(message
                                .substring(startIndex, endIndexExclusive)).reverse();
                        message.delete(startIndex, endIndexExclusive);
                        message.append(reversed);
                        System.out.println(message);
                    } else {
                        System.out.println("error");
                    }
                }
                break;
                case "ChangeAll": {
                    String substring = instructions[1];
                    String replacement = instructions[2];
                    int index = message.indexOf(substring);
                    while (index != -1) {
                        message.replace(index, index + substring.length(), replacement);
                        index = message.indexOf(substring);
                    }
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
