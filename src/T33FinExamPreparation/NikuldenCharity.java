package T33FinExamPreparation;

import java.util.Scanner;

public class NikuldenCharity {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String message = scan.nextLine();
        String input = scan.nextLine();

        while (!"Finish".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Replace": {
                    char currentChar = tokens[1].charAt(0);
                    char newChar = tokens[2].charAt(0);
                    message = message.replace(currentChar, newChar);
                    System.out.println(message);
                    break;
                }
                case "Cut": {
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);

                    if (checkIndexes(message, startIndex, endIndex)) {
                        message = cutSubstring(message, startIndex, endIndex);
                        System.out.println(message);
                    } else {
                        System.out.println("Invalid indexes!");
                    }

                    break;
                }
                case "Make": {
                    command = tokens[1];

                    if ("Upper".equals(command)) {
                        message = message.toUpperCase();
                    } else {
                        message = message.toLowerCase();
                    }

                    System.out.println(message);
                    break;
                }
                case "Check": {
                    String checkString = tokens[1];

                    if (message.contains(checkString)) {
                        System.out.printf("Message contains %s%n", checkString);
                    } else {
                        System.out.printf("Message doesn't contain %s%n", checkString);
                    }

                    break;
                }
                case "Sum": {
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);

                    if (checkIndexes(message, startIndex, endIndex)) {
                        sumASCII(message, startIndex, endIndex);
                    } else {
                        System.out.println("Invalid indexes!");
                    }

                    break;
                }
            }

            input = scan.nextLine();
        }
    }

    private static String cutSubstring(String message, int startIndex, int endIndex) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < startIndex; i++) {
            sb.append(message.charAt(i));
        }

        for (int i = endIndex + 1; i < message.length(); i++) {
            sb.append(message.charAt(i));
        }

        return sb.toString();
    }

    private static void sumASCII(String message, int startIndex, int endIndex) {
        int sum = 0;

        for (int i = startIndex; i <= endIndex; i++) {
            sum = sum + message.charAt(i);
        }

        System.out.println(sum);
    }

    private static boolean checkIndexes(String message, int startIndex, int endIndex) {
        if (startIndex >= 0 && endIndex < message.length())
            return true;

        return false;
    }
}
