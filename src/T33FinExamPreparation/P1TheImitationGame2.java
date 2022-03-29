package T33FinExamPreparation;

import java.util.Scanner;

public class P1TheImitationGame2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder message = new StringBuilder(scanner.nextLine());

        String command = scanner.nextLine();
        while (!command.equals("Decode")) {
            String[] commandParts = command.split("\\|");
            String commandName = commandParts[0];
            switch (commandName) {
                case "Move":
                    move(message, Integer.parseInt(commandParts[1]));
                    break;
                case "Insert":
                    insert(message, Integer.parseInt(commandParts[1]), commandParts[2]);
                    break;
                case "ChangeAll":
                    changeAll(message, commandParts[1], commandParts[2]);
                    break;
                default:
                    throw new IllegalStateException("Unknown command name" + commandName + " in " + command);
//broke the program

            }


            command = scanner.nextLine();
        }

        System.out.println("The decrypted message is: " + message);
    }

    private static void move(StringBuilder message, int length) {
        String firstPart = message.substring(0, length);
        message.replace(0, length, "");
        message.append(firstPart);
    }

    private static void insert(StringBuilder message, int index, String substr) {
        message.insert(index, substr);
    }

    private static void changeAll(StringBuilder message, String substr, String replacement) {
        int nextMatch = message.indexOf(substr);
        while (nextMatch != -1) {
            message.replace(nextMatch, nextMatch + substr.length(), replacement);
            nextMatch = message.indexOf(substr, nextMatch);
        }
        //message.replace(0, message.length(), message.toString().replace(substr, replacement));
    }
}
