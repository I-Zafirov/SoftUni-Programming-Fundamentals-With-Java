package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidEncryptedPassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPasswords = Integer.parseInt(scanner.nextLine());
        Pattern passwordPattern = Pattern
                .compile("(?<start>.+)>(?<digits>\\d{3})\\|(?<lowerCase>[a-z]{3})\\|(?<upperCase>[A-Z]{3})\\|(?<allSymbols>[^<>]{3})<\\1");
        for (int i = 0; i < numberOfPasswords; i++) {
            Matcher passwordMatcher = passwordPattern.matcher(scanner.nextLine());
            if (passwordMatcher.find()) {
                String encryptedPassword = passwordMatcher.group("digits")
                        + passwordMatcher.group("lowerCase")
                        + passwordMatcher.group("upperCase")
                        + passwordMatcher.group("allSymbols");
                System.out.println("Password: " + encryptedPassword);
            } else {
                System.out.println("Try another password!");
            }
        }
    }
}
