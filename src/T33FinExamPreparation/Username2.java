package T33FinExamPreparation;

import java.util.Scanner;

public class Username2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String input = scanner.nextLine();
        while (!input.equals("Sign up")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Case": {
                    if (tokens[1].equals("lower")) {
                        username = username.toLowerCase();
                        System.out.println(username);
                        break;
                    } else if (tokens[1].equals("upper")) {
                        username = username.toUpperCase();
                        System.out.println(username);
                        break;
                    }
                }
                break;
                case "Reverse": {
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    if (startIndex < 0 || startIndex > username.length() || endIndex < 0 || endIndex > username.length()) {
                        break;
                    } else {
                        StringBuilder stringBuilder = new StringBuilder();
                        String cut = username.substring(startIndex, endIndex + 1);
                        stringBuilder.append(cut);
                        stringBuilder = stringBuilder.reverse();
                        System.out.println(stringBuilder);
                    }
                }
                break;
                case "Cut": {
                    String substring = tokens[1];
                    if (username.contains(substring)) {
                        int startIndex = username.indexOf(substring);
                        int endIndex = startIndex + substring.length() - 1;
                        String firstPart = username.substring(0, startIndex);
                        String secondPart = username.substring(endIndex + 1, username.length());
                        username = "";
                        username = firstPart + secondPart;
                        System.out.println(username);
                    } else {
                        System.out.printf("The word %s doesn't contain %s.%n", username, substring);
                    }
                }
                break;
                case "Replace": {
                    String charReplace = tokens[1];
                    String charToReplace = "*";
                    while (username.contains(charReplace)) {
                        username = username.replace(charReplace, charToReplace);
                    }
                    System.out.println(username);
                }
                break;
                case "Check": {
                    String chart = tokens[1];
                    if (username.contains(chart)) {
                        System.out.println("Valid");
                    } else {
                        System.out.printf("Your username must contain %s.%n", chart);
                        break;
                    }
                }
                break;
            }
            input = scanner.nextLine();
        }
    }
}
