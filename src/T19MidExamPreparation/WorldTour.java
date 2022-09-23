package T19MidExamPreparation;

import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        String[] command = scan.nextLine().split(":");

        while (!command[0].equals("Travel")) {
            switch (command[0]) {
                case "Add Stop":
                    int index = Integer.parseInt(command[1]);
                    String stringToInsert = command[2];

                    if (index >= 0 && index < input.length()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(input);
                        sb.insert(index, stringToInsert);
                        input = sb.toString();

                    }
                    System.out.println(input);
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(command[1]);
                    int endIndex = Integer.parseInt(command[2]);

                    if (startIndex >= 0 && startIndex < input.length() &&
                            endIndex >= 0 && endIndex < input.length()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(input);
                        sb.replace(startIndex, endIndex+1, "");
                        input = sb.toString();

                    }
                    System.out.println(input);
                    break;
                case "Switch":
                    String oldString = command[1];
                    String newString = command[2];

                    if(input.contains(oldString)) {
                        input = input.replace(oldString, newString);
                    }

                    System.out.println(input);
                    break;
            }
            command = scan.nextLine().split(":");
        }
        System.out.println("Ready for world tour! Planned stops: " + input);
    }
}
