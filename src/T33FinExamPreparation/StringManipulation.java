package T33FinExamPreparation;

import java.util.Scanner;

public class StringManipulation {
    private static final String ENDCOMMAND = "Done";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();
        String input;
        while (!ENDCOMMAND.equals(input = scanner.nextLine())) {
            String[] tokens = input.split(" ");
            String command = tokens[0];
            String text = "";
            switch (command) {
                case "Change":
                    String toReplace = tokens[1];
                    String replacement = tokens[2];
                    string = string.replace(toReplace, replacement);
                    System.out.println(string);
                    break;
                case "Includes":
                    text = tokens[1];
                    if (string.contains(text)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "End":
                    text = tokens[1];
                    if (string.endsWith(text)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Uppercase":
                    string = string.toUpperCase();
                    System.out.println(string);
                    break;
                case "FindIndex":
                    text = tokens[1];
                    System.out.println(string.indexOf(text));
                    break;
                case "Cut":
                    int firstIndex = Integer.parseInt(tokens[1]);
                    int secondIndex = Integer.parseInt(tokens[2]);
                    string = string.substring(firstIndex, firstIndex + secondIndex);
                    System.out.println(string);
                    break;
            }
        }
    }
}
