package T33FinExamPreparation;

import java.util.Scanner;

public class WarriorsQuest2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();
        String input = scanner.nextLine();
        while (!input.equals("For Azeroth")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "GladiatorStance":
                    string = string.toUpperCase();
                    System.out.println(string);
                    break;
                case "DefensiveStance":
                    string = string.toLowerCase();
                    System.out.println(string);
                    break;
                case "Dispel":
                    int index = Integer.parseInt(tokens[1]);
                    char letter = tokens[2].charAt(0);
                    if (index >= 0 && index < string.length()) {
                        StringBuilder sb = new StringBuilder(string);
                        sb.setCharAt(index, letter);
                        string = sb.toString();
                        System.out.println("Success!");
                    } else {
                        System.out.println("Dispel too weak");
                    }
                    break;
                case "Target":
                    if (tokens[1].equals("Change")) {
                        String subStr = tokens[2];
                        String seconSubStr = tokens[3];
                        string = string.replaceFirst(subStr, seconSubStr);
                        System.out.println(string);
                    } else if (tokens[1].equals("Remove")) {
                        String str = tokens[2];
                        if (string.contains(str)) {
                            string = string.replace(str, "");
                            System.out.println(string);
                        }
                    } else {
                        System.out.println("Command doesn't exist!");
                    }
                    break;
                default:
                    System.out.println("Command doesn't exist!");
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
