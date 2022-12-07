package T33FinExamPreparation;

import java.util.Scanner;

public class StringManipulator2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String input = scanner.nextLine();
        while (!input.equals("Done")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Change": {
                    String curChar = tokens[1];
                    String replacement = tokens[2];
                    while (text.contains(curChar)) {
                        text = text.replace(curChar, replacement);
                    }
                    System.out.println(text);
                }
                break;
                case "Includes": {
                    String string = tokens[1];
                    if (text.contains(string)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                }
                break;
                case "End": {
                    String string = tokens[1];
                    int index = text.indexOf(string);
                    int lengthString = string.length();
                    if (text.endsWith(string)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                }
                break;
                case "Uppercase": {
                    text = text.toUpperCase();
                    System.out.println(text);
                }
                break;
                case "FindIndex": {
                    String chart = tokens[1];
                    if (text.contains(chart)) {
                        int index = text.indexOf(chart);
                        System.out.println(index);
                    }
                }
                break;
                case "Cut": {
                    int startIndex = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);
                    text = text.substring(startIndex, startIndex + length);
                    System.out.println(text);
                }
                break;
            }
            input = scanner.nextLine();
        }
    }
}
