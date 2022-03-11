package T05BasicSyntaxConditionalStatementsAndLoops.exercise;

import java.util.Scanner;

public class x05_Login2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String password = "";

        for (int i = username.length() - 1; i >= 0; i--) {
            password += username.charAt(i);
        }
        String input = scanner.nextLine();
        int count = 0;

        while (true) {
            count++;

            if (input.equals(password)) {
                System.out.printf("User %s logged in.", username);
                break;
            } else {
                if (count == 4) {
                    count++;
                    System.out.printf("User %s blocked!", username);
                    break;
                }
                System.out.println("Incorrect password. Try again.");
            }
            input = scanner.nextLine();
        }
    }
}

