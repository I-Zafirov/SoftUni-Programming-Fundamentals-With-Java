package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TryAnotherPasswordPassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {
            String line = scanner.nextLine();
            Pattern pattern = Pattern
                    .compile("^(.+)>([0-9]{3})\\|([a-z]{3})\\|([A-Z]{3})\\|([^<>]{3})<\\1$");
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                System.out.println("Password: " + matcher.group(2) + matcher.group(3)
                        + matcher.group(4) + matcher.group(5));
            } else {
                System.out.println("Try another password!");
            }
        }
    }
}
