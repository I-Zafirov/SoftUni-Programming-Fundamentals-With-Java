package T37PracticalExam;

import java.util.Scanner;

public class P1DecryptingCommands {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder(scanner.nextLine());
        String line = scanner.nextLine();
        while (!line.equals("Finish")) {
            String[] data = line.split("\\s+");
            String command = data[0];
            switch (command) {
                case "Replace":
                    String currentString = data[1];
                    String newString = data[2];
                    sb = new StringBuilder(sb.toString().replaceAll(currentString, newString));
                    System.out.println(sb);
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(data[1]);
                    int endIndex = Integer.parseInt(data[2]);
                    if (startIndex >= 0 && startIndex < sb.length() && endIndex >= 0 && endIndex < sb.length()) {
                        sb.delete(startIndex, endIndex + 1);
                        System.out.println(sb);
                    } else {
                        System.out.println("Invalid indices!");
                    }
                    break;
                case "Make":
                    String makeText = data[1];
                    String newText = "";
                    switch (makeText) {
                        case "Upper":
                            newText = sb.toString().toUpperCase();
                            sb.delete(0, sb.length());
                            sb.append(newText);
                            System.out.println(sb);
                            break;
                        case "Lower":
                            newText = sb.toString().toLowerCase();
                            sb.delete(0, sb.length());
                            sb.append(newText);
                            System.out.println(sb);
                            break;
                    }
                    break;
                case "Check":
                    String check = data[1];
                    if (sb.toString().contains(check)) {
                        System.out.printf("Message contains %s%n", check);
                    } else {
                        System.out.printf("Message doesn't contain %s%n", check);
                    }
                    break;
                case "Sum":
                    int startIndexSum = Integer.parseInt(data[1]);
                    int endIndexSum = Integer.parseInt(data[2]);
                    int sum = 0;
                    if (startIndexSum >= 0 && startIndexSum < sb.length() && endIndexSum >= 0 && endIndexSum < sb.length()) {
                        for (int i = startIndexSum; i <= endIndexSum; i++) {
                            char currentWord = sb.charAt(i);
                            sum += currentWord;
                        }
                        System.out.println(sum);
                    } else {
                        System.out.println("Invalid indices!");
                    }
                    break;
            }
            line = scanner.nextLine();
        }
    }
}
