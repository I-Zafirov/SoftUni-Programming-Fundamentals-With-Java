package T33FinExamPreparation;

import java.util.Scanner;

public class WorldTour2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder input = new StringBuilder(scanner.nextLine());
        String commandLine = scanner.nextLine();
        while (!commandLine.equals("Travel")) {
            String[] currentCommand = commandLine.split(":");
            String command = currentCommand[0];
            switch (command) {
                case "Add Stop":
                    int index = Integer.parseInt(currentCommand[1]);
                    String string = currentCommand[2];
                    if (index >= 0 && index < input.length()) {
                        input.insert(index, string);
                    }
                    System.out.println(input);
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(currentCommand[1]);
                    int endIndex = Integer.parseInt(currentCommand[2]);
                    if (startIndex >= 0 && startIndex < input.length()) {
                        if (endIndex >= 0 && endIndex < input.length()) {
                            input.delete(startIndex, endIndex + 1);
                        }
                    }
                    System.out.println(input);
                    break;
                case "Switch":
                    String oldString = currentCommand[1];
                    String newString = currentCommand[2];
                    if (input.toString().contains(oldString)) {
                        String temp = input.toString().replace(oldString, newString);
                        input.setLength(0);
                        input.append(temp);
                    }
                    System.out.println(input);
                    break;
            }
            commandLine = scanner.nextLine();
        }
        System.out.printf("Ready for world tour! Planned stops: %s", input);
    }
}
