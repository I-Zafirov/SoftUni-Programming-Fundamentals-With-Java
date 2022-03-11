package T05BasicSyntaxConditionalStatementsAndLoops.exercise;

import java.util.Scanner;

public class x05_Login5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String username = scan.nextLine();
        String password = "";

        for (int position = username.length() - 1; position >= 0; position--) {
            char currentSymbol = username.charAt(position);
            password += currentSymbol;
        }
        String enteredPassword = scan.nextLine();
        int countFailedAttempts = 0;

        while (!enteredPassword.equals(password)) {
            if (countFailedAttempts == 3) {
                System.out.printf("User %s blocked!", username);
                break;
            }
            System.out.println("Incorrect password. Try again.");
            countFailedAttempts++;
            enteredPassword = scan.nextLine();
        }
        if (enteredPassword.equals(password)) {
            System.out.printf("User %s logged in.", username);
        }
    }
}
