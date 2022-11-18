package T33FinExamPreparation;

import java.util.Scanner;

public class NikuldensCharity2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        String input = scanner.nextLine();
        while (!input.equals("Finish")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Replace": {
                    String currentChar = tokens[1];
                    String newChar = tokens[2];
                    while (word.contains(currentChar)) {
                        word = word.replace(currentChar, newChar);
                    }
                    System.out.println(word);
                }
                break;
                case "Cut": {
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    if (startIndex < 0 || startIndex > word.length() || endIndex < 0 || endIndex > word.length()) {
                        System.out.println("Invalid indexes!");
                    } else {
                        StringBuilder stringBuilder = new StringBuilder(word);
                        stringBuilder.delete(startIndex, endIndex + 1);
                        word = "";
                        word = stringBuilder.toString();
                        System.out.println(word);
                    }
                }
                break;
                case "Make": {
                    if (tokens[1].equals("Upper")) {
                        word = word.toUpperCase();
                        System.out.println(word);
                        break;
                    } else if (tokens[1].equals("Lower")) {
                        word = word.toLowerCase();
                        System.out.println(word);
                        break;
                    }
                }
                break;
                case "Check": {
                    String string = tokens[1];
                    if (word.contains(string)) {
                        System.out.println(String.format("Message contains %s", string));
                        break;
                    } else {
                        System.out.println(String.format("Message doesn't contain %s", string));
                    }
                }
                break;
                case "Sum": {
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    if (startIndex < 0 || startIndex > word.length() || endIndex < 0 || endIndex > word.length()) {
                        System.out.println("Invalid indexes!");
                    } else {
                        String cutPart = word.substring(startIndex, endIndex + 1);
                        int sum = 0;
                        for (int i = 0; i < cutPart.length(); i++) {
                            int currentChar = cutPart.charAt(i);
                            sum += currentChar;
                        }
                        System.out.println(sum);
                    }

                }
                break;
            }
            input = scanner.nextLine();
        }
    }
}
