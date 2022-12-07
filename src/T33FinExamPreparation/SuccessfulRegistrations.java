package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SuccessfulRegistrations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;

        int n = Integer.parseInt(scanner.nextLine());
        Pattern pattern = Pattern.compile("(U\\$)(?<user>[A-Z][a-z][a-z]+)\\1(P\\@\\$)(?<pass>[A-Za-z]{5,}[0-9]+)\\3");

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                count += 1;
                String user = matcher.group("user");
                String pass = matcher.group("pass");
                System.out.println("Registration was successful");
                System.out.println("Username: " + user + ", Password: " + pass);
            } else {
                System.out.println("Invalid username or password");
            }

        }

        System.out.println("Successful registrations: " + count);
    }
}
