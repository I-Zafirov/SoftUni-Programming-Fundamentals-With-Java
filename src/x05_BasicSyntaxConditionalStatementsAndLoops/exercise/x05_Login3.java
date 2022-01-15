package x05_BasicSyntaxConditionalStatementsAndLoops.exercise;

import java.util.Scanner;

public class x05_Login3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String password = "";

        for (int i = username.length() - 1; i >= 0; i--) {
            password += username.charAt(i);
        }
        String input = scanner.nextLine();
        int count = 0;

        while (!input.equals(password)) {
            count++;
            if (count == 4) {
                System.out.printf("User %s blocked!", username);
            } else {
                System.out.println("Incorrect password. Try again.");
            }
            input = scanner.nextLine();
        }
        System.out.printf("User %s logged in.", username);
    }
}


