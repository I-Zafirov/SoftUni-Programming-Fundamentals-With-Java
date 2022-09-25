package T33FinExamPreparation;

import java.util.Scanner;

public class ActivationKeys2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String activationKey = scanner.nextLine();
        String command = scanner.nextLine();
        while (!command.equals("Generate")) {
            String[] currentCommand = command.split(">>>");
            String commandWord = currentCommand[0];
            switch (commandWord) {
                case "Contains":
                    String substring = currentCommand[1];
                    if (activationKey.contains(substring)) {
                        System.out.printf("%s contains %s\n", activationKey, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String commandUpLowCase = currentCommand[1];
                    switch (commandUpLowCase) {
                        case "Upper":
                            int startIndex = Integer.parseInt(currentCommand[2]);
                            int endIndex = Integer.parseInt(currentCommand[3]);
                            String oldCase = activationKey.substring(startIndex, endIndex);
                            String upperCase = oldCase.toUpperCase();
                            activationKey = activationKey.replace(oldCase, upperCase);
                            break;
                        case "Lower":
                            startIndex = Integer.parseInt(currentCommand[2]);
                            endIndex = Integer.parseInt(currentCommand[3]);
                            oldCase = activationKey.substring(startIndex, endIndex);
                            String lowerCase = oldCase.toLowerCase();
                            activationKey = activationKey.replace(oldCase, lowerCase);
                            break;
                    }
                    System.out.println(activationKey);
                    break;
                case "Slice":
                    int startIndex = Integer.parseInt(currentCommand[1]);
                    int endIndex = Integer.parseInt(currentCommand[2]);
                    StringBuilder manipulationKey = new StringBuilder();
                    manipulationKey.append(activationKey);
                    manipulationKey.replace(startIndex, endIndex, "");
                    activationKey = manipulationKey.toString();
                    System.out.println(activationKey);
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s", activationKey);
    }
}
