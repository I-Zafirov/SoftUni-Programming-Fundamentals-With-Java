package T33FinExamPreparation;

import java.util.Scanner;

public class Change {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stringToChange = scanner.nextLine();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] commandData = input.split("\\s+");
            String commandName = commandData[0];
            switch (commandName) {
                case "Translate":
                    char symbolToReplace = commandData[1].charAt(0);
                    char newSymbol = commandData[2].charAt(0);
                    stringToChange = stringToChange.replace(symbolToReplace, newSymbol);
                    System.out.println(stringToChange);
                    break;
                case "Includes":
                    String stringToFind = commandData[1];
                    if (stringToChange.contains(stringToFind)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Start":
                    String startingString = commandData[1];
                    if (stringToChange.indexOf(startingString) == 0) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Lowercase":
                    stringToChange = stringToChange.toLowerCase();
                    System.out.println(stringToChange);
                    break;
                case "FindIndex":
                    char symbol = commandData[1].charAt(0);
                    System.out.println(stringToChange.lastIndexOf(symbol));
                    break;
                case "Remove":
                    int startIndex = Integer.parseInt(commandData[1]);
                    int countToRemove = Integer.parseInt((commandData[2]));

                    StringBuilder remover = new StringBuilder();

                    remover.append(stringToChange);
                    remover.delete(startIndex, startIndex + countToRemove);
                    stringToChange = remover.toString();
                    System.out.println(stringToChange);
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
