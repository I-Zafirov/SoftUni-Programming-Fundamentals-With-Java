package T19MidExamPreparation;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder username = new StringBuilder(sc.nextLine());
        StringBuilder correctPassword = new StringBuilder(username);
        correctPassword.reverse();
        int count = 1;

        while (count <= 4) {
            String password = sc.nextLine();
            int comparison = password.compareTo(correctPassword.toString());
            if (0 == comparison) {
                System.out.printf("User %s logged in.", username);
                break;
            } else if (count < 4) {
                System.out.println("Incorrect password. Try again.");
            } else {
                System.out.printf("User %s blocked!", username);
            }
            count++;
        }
    }
}
