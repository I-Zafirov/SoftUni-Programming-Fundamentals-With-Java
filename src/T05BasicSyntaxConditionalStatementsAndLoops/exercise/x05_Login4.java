package T05BasicSyntaxConditionalStatementsAndLoops.exercise;

import java.util.Scanner;

public class x05_Login4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String username = scan.nextLine();
        String password = "";
        int timesBlocked = 0;

        for (int i = username.length() - 1; i >= 0; i--) {
            password += username.charAt(i);
        }
        while (timesBlocked < 4) {
            String input = scan.nextLine();
            if (input.equals(password)) {
                System.out.printf("User %s logged in.", username);
                return;
            } else if (timesBlocked < 3) {
                System.out.println("Incorrect password. Try again.");
            }
            timesBlocked++;
        }
        if (timesBlocked == 4) {
            System.out.printf("User %s blocked!", username);
        }
    }
}

