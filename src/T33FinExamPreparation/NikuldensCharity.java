package T33FinExamPreparation;

import java.util.Scanner;

public class NikuldensCharity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String input;
        while (!"Finish".equals(input = scanner.nextLine())) {
            String[] tokens = input.split(" ");
            String command = tokens[0];
            switch (command) {
                case "Replace":
                    text = text.replace(tokens[1], tokens[2]);
                    System.out.println(text);
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    StringBuilder sb = new StringBuilder();
                    if (startIndex >= 0 && startIndex < text.length() && endIndex > 0 && endIndex < text.length()) {
                        String firstHalf = text.substring(0, startIndex);
                        String secondHalf = text.substring(endIndex + 1);

                        sb.append(firstHalf);
                        sb.append(secondHalf);
                        text = sb.toString();
                        System.out.println(text);
                    } else {
                        System.out.println("Invalid indexes!");
                    }
                    break;
                case "Make":
                    if (tokens[1].equals("Upper")) {
                        text = text.toUpperCase();
                        System.out.println(text);
                    } else if (tokens[1].equals("Lower")) {
                        text = text.toLowerCase();
                        System.out.println(text);
                    }
                    break;
                case "Check":
                    if (text.contains(tokens[1])) {
                        System.out.println("Message contains " + tokens[1]);
                    } else {
                        System.out.println("Message doesn't contain " + tokens[1]);
                    }
                    break;
                case "Sum":
                    startIndex = Integer.parseInt(tokens[1]);
                    endIndex = Integer.parseInt(tokens[2]);
                    sb = new StringBuilder();
                    if (startIndex >= 0 && startIndex < text.length() && endIndex > 0 && endIndex < text.length()) {

                        String string = text.substring(startIndex, endIndex + 1);
                        int num = 0;
                        for (int i = 0; i < string.length(); i++) {
                            num += string.charAt(i);
                        }
                        System.out.println(num);
                    } else {
                        System.out.println("Invalid indexes!");
                    }
                    break;
            }
        }
    }
}
