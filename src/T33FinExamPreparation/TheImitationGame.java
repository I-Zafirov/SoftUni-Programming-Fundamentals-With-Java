package T33FinExamPreparation;

import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();
        String input = scanner.nextLine();
        while (!"Decode".equals(input)) {
            String[] instructions = input.split("\\|");
            switch (instructions[0]) {
                case "Move":
                    int numberOfLetters = Integer.parseInt(instructions[1]);
                    String firstPart = message.substring(0, numberOfLetters);
                    String secondPart = message.substring(numberOfLetters);
                    message = secondPart + firstPart;
                    break;
                case "Insert":
                    int index = Integer.parseInt(instructions[1]);
                    String value = instructions[2];
                    StringBuilder sb = new StringBuilder();
                    sb.append(message);
                    sb.insert(index, value);
                    message = sb.toString();
                    break;
                case "ChangeAll":
                    String substring = instructions[1];
                    String replacement = instructions[2];
                    message = message.replace(substring, replacement);
                    break;
                default:
                    System.out.println("Invalid command: " + instructions[0]);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println("The decrypted message is: " + message);
    }
}
