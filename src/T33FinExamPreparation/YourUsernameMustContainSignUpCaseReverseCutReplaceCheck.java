package T33FinExamPreparation;

import java.util.Scanner;

public class YourUsernameMustContainSignUpCaseReverseCutReplaceCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder username = new StringBuilder(scanner.nextLine());
        String commandsInput = scanner.nextLine();
        while (!commandsInput.equals("Sign up")) {
            String[] tokens = commandsInput.split(" ");
            String command = tokens[0];
            switch (command) {
                case "Case":
                    String lowerOrUpper = tokens[1];
                    for (int i = 0; i <= username.length() - 1; i++) {
                        char currentChar = username.charAt(i);
                        if (lowerOrUpper.equals("lower")) {
                            username.setCharAt(i, Character.toLowerCase(currentChar));
                        } else if (lowerOrUpper.equals("upper")) {
                            username.setCharAt(i, Character.toUpperCase(currentChar));
                        }
                    }
                    System.out.println(username.toString());
                    break;
                case "Reverse":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    StringBuilder reversed = new StringBuilder();
                    String replacedMessage = "";
                    if (isValid(startIndex, username.length()) && isValid(endIndex, username.length())) {
                        replacedMessage = username.substring(startIndex, endIndex + 1);
                    } else {
                        break;
                    }
                    for (int i = replacedMessage.length() - 1; i >= 0; i--) {
                        char currentChar = replacedMessage.charAt(i);
                        reversed.append(currentChar);
                    }
                    System.out.println(reversed.toString());
                    break;
                case "Cut":
                    String substring = tokens[1];
                    if (username.toString().contains(substring)) {
                        username = new StringBuilder(username.toString().replace(substring, ""));
                        System.out.println(username.toString());
                    } else {
                        System.out.printf("The word %s doesn't contain %s.%n", username.toString(), substring);
                    }
                    break;
                case "Replace":
                    char charToBeReplaced = tokens[1].charAt(0);
                    username = new StringBuilder(username.toString().replace(charToBeReplaced, '*'));
                    System.out.println(username.toString());
                    break;
                case "Check":
                    char charToBeChecked = tokens[1].charAt(0);
                    if (username.toString().indexOf(charToBeChecked) != -1) {
                        System.out.println("Valid");
                    } else {
                        System.out.printf("Your username must contain %c.%n", charToBeChecked);
                    }
                    break;
            }
            commandsInput = scanner.nextLine();
        }
    }

    private static boolean isValid(int startIndex, int length) {
        return startIndex >= 0 && startIndex <= length - 1;
    }
}
