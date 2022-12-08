package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SuccessfulRegistrationsInvalidUsernameOrPassword2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String regex = "U\\$(?<username>[A-Z][a-z][a-z]+)U\\$P@\\$(?<password>[A-Za-z]{5,}[0-9]+)P@\\$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                counter++;
                System.out.println("Registration was successful");
                System.out.printf("Username: %s, Password: %s%n",
                        matcher.group("username"), matcher.group("password"));
            } else {
                System.out.println("Invalid username or password");
            }
        }
        System.out.println("Successful registrations: " + counter);
    }
}
