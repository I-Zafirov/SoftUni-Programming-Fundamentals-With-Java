package T33FinExamPreparation;

import java.util.Scanner;

public class ReadyForWorldTourPlannedStopsTravelAddStopRemoveStopSwitch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String input = scanner.nextLine();
        while (!input.equals("Travel")) {
            String[] tokens = input.split(":");
            String command = tokens[0];
            switch (command) {
                case "Add Stop": {
                    int index = Integer.parseInt(tokens[1]);
                    String string = tokens[2];
                    if (index >= 0 && index < text.length()) {
                        String first = text.substring(0, index);
                        String second = text.substring(index, text.length());
                        text = "";
                        text = first + string + second;
                        System.out.println(text);
                    }
                }
                break;
                case "Remove Stop": {
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    if (startIndex > 0 || startIndex < text.length() && endIndex > 0 || endIndex < text.length()) {
                        if (startIndex == 0 && endIndex == 0) {
                            System.out.println(text);
                            break;
                        }
                        String first = text.substring(0, startIndex);
                        String secondPart = text.substring(endIndex + 1, text.length());
                        text = "";
                        text = first + secondPart;
                        System.out.println(text);
                    }
                }
                break;
                case "Switch": {
                    String oldString = tokens[1];
                    String newString = tokens[2];
                    while (text.contains(oldString)) {
                        text = text.replace(oldString, newString);
                    }
                    System.out.println(text);
                }
                break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Ready for world tour! Planned stops: %s", text);
    }
}
