package T33FinExamPreparation;

import java.util.Scanner;

public class StringManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String data = scanner.nextLine();
        String expression;
        String[] command;

        while (!(expression = scanner.nextLine()).equals("Done")) {
            command = expression.split("\\s+");
            switch (command[0]) {
                case "Change":
                    data = changesSymbols(data, command[1].charAt(0), command[2]);
                    break;
                case "Includes":
                    includesString(data, command[1]);
                    break;
                case "End":
                    endsWithExpression(data, command[1]);
                    break;
                case "Uppercase":
                    data = uppercaseString(data);
                    break;
                case "FindIndex":
                    findsIndex(data, command[1].charAt(0));
                    break;
                case "Cut":
                    cutsLetters(data, Integer.parseInt(command[1]), Integer.parseInt(command[2]));
                    break;
                default:
                    break;
            }
        }
    }

    public static String changesSymbols(String data, char target, String replacement) {
        StringBuilder sb = new StringBuilder();
        for (int a = 0; a < data.length(); a++) {
            if (data.charAt(a) != target) {
                sb.append(data.charAt(a));
            } else {
                sb.append(replacement);
            }
        }
        System.out.println(sb);
        return data = "" + sb;
    }

    public static void includesString(String data, String target) {
        if (data.contains(target)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    public static void endsWithExpression(String data, String target) {
        if (data.contains(target)) {
            int counter = 0;
            for (int b = 0; b < data.length(); b++) {
                if (target.length() - 1 - b < 0) {
                    break;
                }
                if (target.charAt(target.length() - 1 - b) == data.charAt(data.length() - 1 - b)) {
                    counter++;
                }
            }
            if (counter == target.length()) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        } else {
            System.out.println("False");
        }
    }

    public static String uppercaseString(String data) {
        data = data.toUpperCase();
        System.out.println(data);

        return data;
    }

    public static void findsIndex(String data, char letter) {
        System.out.println(data.indexOf(letter));
    }

    public static void cutsLetters(String data, int startIndex, int count) {
        StringBuilder sb2 = new StringBuilder();
        for (int c = 0; c < data.length(); c++) {
            if (c >= startIndex && c < startIndex + count) {
                sb2.append(data.charAt(c));
            }
        }
        System.out.println(sb2);
    }
}
