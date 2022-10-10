package T33FinExamPreparation;

import java.util.Scanner;

public class EmailValidator3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String email = scanner.nextLine();
        String input = scanner.nextLine();
        while (!input.equals("Complete")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Make": {
                    if (tokens[1].equals("Upper")) {
                        email = email.toUpperCase();
                        System.out.println(email);
                        break;
                    } else if (tokens[1].equals("Lower")) {
                        email = email.toLowerCase();
                        System.out.println(email);
                        break;
                    }
                }
                break;
                case "GetDomain": {
                    int count = Integer.parseInt(tokens[1]);
                    for (int i = email.length() - count; i < email.length(); i++) {
                        char currentChar = email.charAt(i);
                        System.out.print(currentChar);
                    }
                    System.out.println();
                }
                break;
                case "GetUsername": {
                    String symbol = "@";
                    if (email.contains(symbol)) {
                        int endIndex = email.indexOf(symbol);
                        String partOfEmail = "";
                        partOfEmail = email.substring(0, endIndex);
                        System.out.println(partOfEmail);
                    } else {
                        System.out.printf("The email %s doesn't contain the @ symbol.%n", email);
                    }
                }
                break;
                case "Replace": {
                    String charReplacing = tokens[1];
                    String newChar = "-";
                    while (email.contains(charReplacing)) {
                        email = email.replace(charReplacing, newChar);
                    }
                    System.out.println(email);
                }
                break;
                case "Encrypt": {

                    for (int i = 0; i < email.length(); i++) {
                        int currentChar = email.charAt(i);
                        if ((i) == (email.length() - 1)) {
                            System.out.print(currentChar);
                        } else {
                            System.out.print(currentChar + " ");
                        }
                    }
                }
                break;
            }
            input = scanner.nextLine();
        }
    }
}
