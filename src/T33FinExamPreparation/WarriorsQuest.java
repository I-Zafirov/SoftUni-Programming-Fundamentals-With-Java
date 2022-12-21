package T33FinExamPreparation;

import java.util.Scanner;

public class WarriorsQuest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();

        String input = scanner.nextLine();

        while (!input.equals("For Azeroth")) {

            String[] tokens = input.split(" ");
            String command = tokens[0];
            switch (command) {
                case "GladiatorStance": {
                    word = word.toUpperCase();
                    System.out.println(word);
                }
                break;
                case "DefensiveStance": {
                    word = word.toLowerCase();
                    System.out.println(word);
                }
                break;
                case "Dispel": {
                    int index = Integer.parseInt(tokens[1]);
                    char letter = tokens[2].charAt(0);
//                    Replace the letter at the index with the given one and print "Success!"
//                    If the index is invalid, print: "Dispel too weak."
                    if (index < 0 || index > word.length()) {
                        System.out.println("Dispel too weak.");
                        break;
                    } else {
                        char currentChar = word.charAt(index);
                        StringBuilder stringBuilder = new StringBuilder(word);
                        stringBuilder.setCharAt(index, letter);
                        word = "";
                        word = stringBuilder.toString();
                        System.out.println("Success!");
                    }
                }
                break;
                case "Target": {
                    if (tokens[1].equals("Change")) {
                        String substring = tokens[2];
                        String secondSubstring = tokens[3];

                        if (word.contains(substring)) {
                            word = word.replace(substring, secondSubstring);
                            System.out.println(word);

                        } else {
                            break;
                        }

                    } else if (tokens[1].equals("Remove")) {
                        String substring = tokens[2];
                        if (word.contains(substring)) {
                            word = word.replace(substring, "");
                            System.out.println(word);
                            break;
                        } else {
                            break;
                        }
                    } else {
                        System.out.println("Command doesn't exist!");
                        break;
                    }
                }
                break;
                default:
                    System.out.println("Command doesn't exist!");
            }
            input = scanner.nextLine();

        }
    }
}
