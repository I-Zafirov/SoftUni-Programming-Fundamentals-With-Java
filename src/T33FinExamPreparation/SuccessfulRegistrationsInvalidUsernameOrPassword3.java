package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SuccessfulRegistrationsInvalidUsernameOrPassword3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int count = 0;
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Pattern pattern = Pattern
                    .compile("^(U\\$)(?<username>[A-Z][a-z]{2,})\\1[\\w\\W]*?(P@\\$)(?<password>[A-Za-z]{5,}[0-9]+)\\3$");
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String username = matcher.group("username");
                String pass = matcher.group("password");
                System.out.println("Registration was successful");
                System.out.println("Username: " + username + ", Password: " + pass);
                count++;
            } else {
                System.out.println("Invalid username or password");
            }
        }
        System.out.println("Successful registrations: " + count);
    }
}
