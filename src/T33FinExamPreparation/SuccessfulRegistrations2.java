package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SuccessfulRegistrations2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "(U\\$)([A-Z][a-z]{2,})(U\\$)(P@\\$)([A-Za-z]{5,}\\d+)(P@\\$)";

        Pattern pattern = Pattern.compile(regex);

        int n = Integer.parseInt(scanner.nextLine());
        int registrations = 0;

        for (int i = 0; i < n; i++) {
            String registration = scanner.nextLine();
            Matcher matcher = pattern.matcher(registration);
            if (matcher.find()) {
                registrations++;
                System.out.println("Registration was successful");
                System.out.println(String.format("Username: %s, Password: %s", matcher.group(2), matcher.group(5)));
            } else {
                System.out.println("Invalid username or password");
            }
        }

        System.out.println(String.format("Successful registrations: %d", registrations));
    }
}
