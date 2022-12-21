package T33FinExamPreparation;

import java.util.Scanner;

public class WorldTour3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder text = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();
        while (!input.equals("Travel")) {
            String[] tokens = input.split(":");
            String command = tokens[0];
            switch (command) {
                case "Add Stop":
                    int indexToBeAddedAt = Integer.parseInt(tokens[1]);
                    String wordToBeAdded = tokens[2];
                    if (isValid(indexToBeAddedAt, text.length())) {
                        text.insert(indexToBeAddedAt, wordToBeAdded);
                    }
                    System.out.println(text.toString());
                    break;
                case "Remove Stop":
                    int startIndexToBeDeleted = Integer.parseInt(tokens[1]);
                    int endIndexToBeDeleted = Integer.parseInt(tokens[2]);

                    if (isValid(startIndexToBeDeleted, text.length()) && isValid(endIndexToBeDeleted, text.length())) {
                        text.delete(startIndexToBeDeleted, endIndexToBeDeleted + 1);
                    }
                    System.out.println(text);
                    break;
                case "Switch":
                    String oldString = tokens[1];
                    String newString = tokens[2];
                    String replacedString = text.toString().replace(oldString, newString);
                    text = new StringBuilder(replacedString);
                    System.out.println(text.toString());
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.printf("Ready for world tour! Planned stops: %s%n", text.toString());
    }

    private static boolean isValid(int indexToBeAddedAt, int length) {
        return indexToBeAddedAt >= 0 && indexToBeAddedAt <= length - 1;
    }
}
