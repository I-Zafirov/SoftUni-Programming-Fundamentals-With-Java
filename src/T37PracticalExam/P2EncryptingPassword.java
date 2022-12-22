package T37PracticalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P2EncryptingPassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {
            String line = scanner.nextLine();

            Pattern pattern = Pattern
                    .compile("^(.+)>(?<numbers>[0-9]{3})\\|(?<lower>[a-z]{3})\\|(?<upper>[A-Z]{3})\\|(?<symbols>[^<>]{3})<\\1$");
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                System.out.println("Password: " + matcher.group("numbers") + matcher.group("lower")
                        + matcher.group("upper") + matcher.group("symbols"));
            } else {
                System.out.println("Try another password!");
            }
        }
    }
}
