package T33FinExamPreparation;

import java.util.Scanner;

public class ValidUsernameMustBeContainedInYourUsername {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String input = scanner.nextLine();
        while (!input.equals("Registration")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Letters":
                    StringBuilder sb = new StringBuilder();
                    if (tokens[1].equals("Lower")) {
                        for (int i = 0; i < username.length(); i++) {
                            char currentLetter = username.charAt(i);
                            sb.append(Character.toLowerCase(currentLetter));
                        }
                    } else if (tokens[1].equals("Upper")) {
                        for (int i = 0; i < username.length(); i++) {
                            char currentLetter = username.charAt(i);
                            sb.append(Character.toUpperCase(currentLetter));
                        }
                    }
                    username = sb.toString();
                    System.out.println(username);
                    break;
                case "Reverse":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    if (isValidIndex(startIndex, username.length()) && isValidIndex(endIndex, username.length())) {
                        StringBuilder sbUsername = new StringBuilder(username.substring(startIndex, endIndex + 1));
                        sbUsername.reverse();
                        System.out.println(sbUsername.toString());
                    }
                    break;
                case "Substring":
                    String substring = tokens[1];
                    if (username.contains(substring)) {
                        username = username.replace(substring, "");
                        System.out.println(username);
                    } else {
                        System.out.printf("The username %s doesn't contain %s.%n", username, substring);
                    }
                    break;
                case "Replace":
                    char symbolToReplace = tokens[1].charAt(0);
                    username = username.replace(symbolToReplace, '-');
                    System.out.println(username);
                    break;
                case "IsValid":
                    char symbol = tokens[1].charAt(0);
                    if (username.contains(Character.toString(symbol))) {
                        System.out.println("Valid username.");
                    } else {
                        System.out.printf("%c must be contained in your username.%n", symbol);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
    }

    private static boolean isValidIndex(int index, int size) {
        return index >= 0 && index < size;
    }
}
