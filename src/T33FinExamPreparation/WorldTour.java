package T33FinExamPreparation;

import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder allStops = new StringBuilder(scanner.nextLine());
        String command = scanner.nextLine();

        while (!"Travel".equals(command)) {
            String[] commandParts = command.split(":");
            switch (commandParts[0]) {
                case "Add Stop":
                    int insertIndex = Integer.parseInt(commandParts[1]);
                    String insertString = commandParts[2];
                    if (isValidIndex(allStops, insertIndex)) {
                        allStops.insert(insertIndex, insertString);
                    }
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(commandParts[1]);
                    int endIndexInclusive = Integer.parseInt(commandParts[2]);
                    if (isValidIndex(allStops, startIndex) && isValidIndex(allStops, endIndexInclusive)) {
                        allStops.replace(startIndex, endIndexInclusive + 1, ""); // Remove from to excluding
                        //allStops.delete(startIndex, endIndexInclusive + 1); // Delete from to excluding
                        //As we need to remove last index in sb we indicate - to last index + 1
                    }
                    break;
                case "Switch":
                    String oldString = commandParts[1];
                    String newString = commandParts[2];
                    //allStops = new StringBuilder(allStops.toString().replace(oldString, newString));
                    allStops.replace(allStops.indexOf(oldString), allStops.indexOf(oldString) + oldString.length(), newString);
                    break;
                default:
                    System.out.println("Unknown command: " + command);
                    break;
            }
            System.out.println(allStops);
            command = scanner.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: " + allStops);
    }

    private static boolean isValidIndex(StringBuilder s, int index) {
        return index >= 0 && index < s.length();
    }
}
