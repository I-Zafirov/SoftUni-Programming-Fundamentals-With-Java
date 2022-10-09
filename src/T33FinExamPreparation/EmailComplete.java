package T33FinExamPreparation;

import java.util.Scanner;

public class EmailComplete {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String command = scan.nextLine();
        while (!command.equals("Complete")) {
            String[] commandArr = command.split(" ");
            switch (commandArr[0]) {
                case "Make":
                    switch (commandArr[1]) {
                        case "Upper":
                            input = getUpper(input);
                            break;
                        case "Lower":
                            input = getLower(input);
                            break;
                    }
                    System.out.println(input);
                    break;
                case "GetDomain":
                    String domain = getDomain(input, Integer.parseInt(commandArr[1]));
                    System.out.println(domain);
                    break;
                case "GetUsername":
                    if (input.contains("@")) {
                        String username = getUsername(input);
                        System.out.println(username);
                    } else {
                        System.out.printf("The email %s doesn't contain the @ symbol.", input);
                    }
                    break;
                case "Replace":
                    input = doReplace(input, commandArr[1]);
                    System.out.println(input);
                    break;
                case "Encrypt":
                    for (int i = 0; i < input.length(); i++) {
                        System.out.print((int) input.charAt(i));
                        if (i < (input.length() - 1)) {
                            System.out.print(" ");
                        }
                    }
                    break;
            }

            command = scan.nextLine();
        }
        scan.close();


    }

    private static String doReplace(String input, String symbol) {
        input = input.replaceAll(symbol, "-");
        return input;
    }

    private static String getUsername(String input) {
        int index = input.indexOf('@');
        String output = input.substring(0, index);
        return output;
    }

    private static String getDomain(String input, int count) {
        int first = input.length() - count;
        String output = input.substring(first, input.length());
        return output;
    }

    private static String getLower(String input) {
        input = input.toLowerCase();
        return input;
    }

    private static String getUpper(String input) {
        input = input.toUpperCase();
        return input;
    }
}
