package T19MidExamPreparation;

import java.util.Scanner;

public class WorldTour2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String command = scan.nextLine();
        while (!command.equals("Travel")) {
            String[] commandArr = command.split(":");
            switch (commandArr[0]) {
                case "Add Stop":
                    input = addStop(input, Integer.parseInt(commandArr[1]), commandArr[2]);
                    break;
                case "Remove Stop":
                    input = removeStop(input, Integer.parseInt(commandArr[1]), (Integer.parseInt(commandArr[2]) + 1));
                    break;
                case "Switch":
                    input = switchStop(input, commandArr[1], commandArr[2]);
                    break;
            }

            System.out.println(input);

            command = scan.nextLine();
        }
        scan.close();

        System.out.printf("Ready for world tour! Planned stops: %s", input);

    }

    private static String switchStop(String input, String oldString, String newString) {
        if (input.contains(oldString)) {
            input = input.replaceFirst(oldString, newString);
        }
        return input;
    }

    private static String removeStop(String input, int startIndex, int endIndex) {
        if ((0 <= startIndex) && (startIndex < endIndex) && (endIndex < input.length())) {
            StringBuilder sb = new StringBuilder();
            sb.append(input);
            sb.replace(startIndex, endIndex, "");
            input = sb.toString();
        }
        return input;
    }

    private static String addStop(String input, int index, String newStop) {
        if ((0 <= index) && (index < input.length())) {
            StringBuilder sb = new StringBuilder();
            sb.append(input);
            sb.insert(index, newStop);
            input = sb.toString();
        }
        return input;
    }
}
