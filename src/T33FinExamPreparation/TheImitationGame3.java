package T33FinExamPreparation;

import java.util.Scanner;

public class TheImitationGame3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder input = new StringBuilder(scanner.nextLine());
        String command = scanner.nextLine();
        while (!command.equals("Decode")) {
            String[] currentCommand = command.split("\\|");
            String commandLine = currentCommand[0];
            switch (commandLine) {
                case "Move":
                    int numberOfLetters = Integer.parseInt(currentCommand[1]);
                    while (numberOfLetters > 0) {
                        input.append(input.charAt(0));
                        input.deleteCharAt(0);
                        numberOfLetters--;
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(currentCommand[1]);
                    String value = currentCommand[2];
                    input.insert(index, value);
                    break;
                case "ChangeAll":
                    String substring = currentCommand[1];
                    String replacement = currentCommand[2];
                    String temp = input.toString().replace(substring, replacement);
                    input.setLength(0);
                    input.append(temp);
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.printf("The decrypted message is: %s", input);
    }
}
