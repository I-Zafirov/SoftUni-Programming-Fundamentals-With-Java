package T33FinExamPreparation;

import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder rawPassword = new StringBuilder(scanner.nextLine());
        String commandLine = scanner.nextLine();
        while (!commandLine.equals("Done")) {
            String[] inputCommand = commandLine.split(" ");
            switch (inputCommand[0]) {
                case "TakeOdd":
                    String newString = "";
                    for (int i = 1; i < rawPassword.length(); i += 2) {
                        char character = rawPassword.charAt(i);
                        newString += character;
                    }
                    rawPassword.replace(0, rawPassword.length(), newString);
                    System.out.println(rawPassword);
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(inputCommand[1]);
                    int length = Integer.parseInt(inputCommand[2]);
                    int endIndex = startIndex + length;
                    String substring = rawPassword.substring(startIndex, endIndex);
                    int index = rawPassword.indexOf(substring);
                    rawPassword.replace(index, index + substring.length(), "");
                    System.out.println(rawPassword);
                    break;
                case "Substitute":
                    String substringForReplace = inputCommand[1];
                    String substitute = inputCommand[2];
                    if (rawPassword.toString().contains(substringForReplace)) {
                        String helpString = rawPassword.toString()
                                .replace(substringForReplace, substitute);
                        rawPassword.replace(0, rawPassword.length(), helpString);
                        System.out.println(rawPassword);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }
            commandLine = scanner.nextLine();
        }
        System.out.printf("Your password is: %s", rawPassword);
    }
}
