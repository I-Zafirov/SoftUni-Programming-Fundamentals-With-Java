package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String regex = "U\\$(?<username>[A-Z][a-z]{2,})U\\$P@\\$(?<pass>[a-z]{5,}[0-9]+)P@\\$";
        Pattern pattern = Pattern.compile(regex);
        int regCount = 0;
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                regCount++;
                System.out.println("Registration was successful");
                System.out.printf("Username: %s, Password: %s%n", matcher.group("username"), matcher.group("pass"));
            } else {
                System.out.println("Invalid username or password");
            }
        }
        System.out.printf("Successful registrations: %d", regCount);
    }
}
