package T33FinExamPreparation;

import java.util.Scanner;

public class InvalidIndicesMessageContainsInvalidIndices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();
        while (!"Finish".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Replace":
                    String firstChar = tokens[1];
                    String secondChar = tokens[2];
                    if (sb.toString().contains(firstChar)) {
                        StringBuilder temp = new StringBuilder(sb.toString().replace(firstChar, secondChar));
                        System.out.println(temp);
                        sb = temp;
                    }
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    if (startIndex >= 0 && startIndex < sb.length() && endIndex >= 0 && endIndex < sb.length()) {
                        String substring1 = sb.toString().substring(0, startIndex);
                        String substring2 = sb.toString().substring(endIndex + 1, sb.length());
                        StringBuilder temp = new StringBuilder(substring1 + substring2);
                        System.out.println(temp);
                        sb = temp;
                    } else {
                        System.out.println("Invalid indices!");
                    }
                    break;
                case "Make":
                    String upperLower = tokens[1];
                    if (upperLower.equals("Upper")) {
                        StringBuilder temp = new StringBuilder(sb.toString().toUpperCase());
                        System.out.println(temp);
                        sb = temp;
                    } else if (upperLower.equals("Lower")) {
                        StringBuilder temp = new StringBuilder(sb.toString().toLowerCase());
                        System.out.println(temp);
                        sb = temp;
                    }
                    break;
                case "Check":
                    String checkMessage = tokens[1];
                    if (sb.toString().contains(checkMessage)) {
                        System.out.println(String.format("Message contains %s", checkMessage));
                    } else {
                        System.out.println(String.format("Message doesn't contain %s", checkMessage));
                    }
                    break;
                case "Sum":
                    int startIndex1 = Integer.parseInt(tokens[1]);
                    int endIndex1 = Integer.parseInt(tokens[2]);
                    int sum = 0;
                    if (startIndex1 >= 0 && startIndex1 < sb.length() && endIndex1 >= 0 && endIndex1 < sb.length()) {
                        String temp = sb.toString().substring(startIndex1, endIndex1 + 1);
                        for (int i = 0; i < temp.length(); i++) {
                            char current = temp.charAt(i);
                            sum += Integer.valueOf(current);
                        }
                        System.out.println(sum);
                    } else {
                        System.out.println("Invalid indices!");
                    }

                    break;
            }

            input = scanner.nextLine();
        }


    }
}
