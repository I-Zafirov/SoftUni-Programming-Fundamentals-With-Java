package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        String expression, userName = "", password = "";
        Pattern pattern = Pattern.compile("^(U\\$)(?<userName>[A-Z][a-z][a-z]+)(U\\$)(P\\@\\$)(?<password>[A-Za-z]{5}[A-za-z0-9]*[\\d])(P\\@\\$)$");

        for (int a = 1; a <= number; a++) {
            expression = scanner.nextLine();
            Matcher data = pattern.matcher(expression);
            while (data.find()) {
                userName = data.group("userName");
                password = data.group("password");
            }
            if (!userName.equals("") && !password.equals("")) {
                System.out.println("Registration was successful");
                System.out.printf("Username: %s, Password: %s%n", userName, password);
                counter++;
            } else if (userName.equals("") && password.equals("")) {
                System.out.println("Invalid username or password");
            }
            userName = "";
            password = "";
        }
        System.out.printf("Successful registrations: %d", counter);
    }
}
