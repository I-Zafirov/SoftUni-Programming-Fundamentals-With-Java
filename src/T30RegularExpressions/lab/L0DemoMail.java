package T30RegularExpressions.lab;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class L0DemoMail {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("^\\w+@[A-Za-z]+\\.[A-Za-z]+$");

        String userMail = new Scanner(System.in).nextLine();

        Matcher matcher = pattern.matcher(userMail);

        boolean isValid = matcher.find();

        if (isValid) {
            System.out.println("Valid");
        } else {
            System.out.println("Not valid");
        }
    }
}
