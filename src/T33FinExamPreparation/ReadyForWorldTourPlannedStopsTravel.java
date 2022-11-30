package T33FinExamPreparation;

import java.util.Scanner;

public class ReadyForWorldTourPlannedStopsTravel {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String stops = scan.nextLine();
        StringBuilder sb = new StringBuilder(stops);
        String command = scan.nextLine();
        while (!"Travel".equals(command)) {
            String[] tokens = command.split(":");
            switch (tokens[0]) {
                case "Add Stop":
                    int index = Integer.parseInt(tokens[1]);
                    String string = tokens[2];
                    if (index >= 0 && index < sb.length()) {
                        sb.insert(index, string);
                    }
                    System.out.println(sb);
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int stopIndex = Integer.parseInt(tokens[2]);
                    if (startIndex >= 0 && startIndex < sb.length() && stopIndex >= 0 && stopIndex < sb.length()) {
                        sb.replace(startIndex, stopIndex + 1, "");
                    }
                    System.out.println(sb);
                    break;
                case "Switch":
                    String oldString = tokens[1];
                    String newString = tokens[2];
                    if (sb.toString().contains(oldString)) {
                        startIndex = sb.indexOf(oldString);
                        sb.replace(startIndex, startIndex + oldString.length(), newString);
                    }
                    System.out.println(sb);
                    break;
            }
            command = scan.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: " + sb);
    }
}
