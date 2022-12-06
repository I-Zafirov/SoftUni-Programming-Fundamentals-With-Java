package T33FinExamPreparation;

import java.util.Scanner;

public class StringGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String command = scanner.nextLine();
        while (!command.equals("Done")) {
            String[] arr = command.split("\\s+");
            String currentCommand = arr[0];

            switch (currentCommand) {
                case "Change":
                    String change = arr[1];
                    String replacement = arr[2];
                    input = input.replace(change, replacement);
                    System.out.println(input);
                    break;
                case "Includes":
                    if (input.contains(arr[1])) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "End":
                    if (input.endsWith(arr[1])) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Uppercase":
                    input = input.toUpperCase();
                    System.out.println(input);
                    break;
                case "FindIndex":
                    int firstIndex = input.indexOf(arr[1]);
                    System.out.println(firstIndex);
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(arr[1]);
                    int length = Integer.parseInt(arr[2]);
                    String substring = input.substring(startIndex, startIndex + length);
                    System.out.println(substring);
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
