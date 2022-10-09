package T33FinExamPreparation;

import java.util.Scanner;

public class Email {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String email = scanner.nextLine();
        String input = scanner.nextLine();
        while (!"Complete".equals(input)) {
            String[] tokens = input.split("\\s+");
            switch (tokens[0]) {
                case "Make":
                    String type = tokens[1];
                    if (type.equals("Upper")) {
                        email = email.toUpperCase();
                    } else if (type.equals("Lower")) {
                        email = email.toLowerCase();
                    }
                    System.out.println(email);
                    break;
                case "GetDomain":
                    int num = Integer.parseInt(tokens[1]);
                    String substring = email.substring(email.length() - num);
                    System.out.println(substring);
                    break;
                case "GetUsername":
                    if (email.contains("@")) {
                        int endIndexExclusive = email.indexOf("@");
                        String username = email.substring(0, endIndexExclusive);
                        System.out.println(username);
                    } else {
                        System.out.printf("The email %s doesn't contain the @ symbol.%n", email);
                    }
                    break;
                case "Replace":
                    String symbol = tokens[1];
                    email = email.replace(symbol, "-");
                    System.out.println(email);
                    break;
                case "Encrypt":
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < email.length(); i++) {
                        int asciiNum = email.charAt(i);
                        if (i < email.length() - 1) {
                            sb.append(asciiNum + " ");
                        } else {
                            sb.append(asciiNum);
                        }
                    }
                    System.out.println(sb);
                    break;
                default:
                    System.out.println("Wrong command " + tokens[0]);
            }
            input = scanner.nextLine();
        }
    }
}
