package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String regex = "^(.+)>(?<num>\\d{3})\\|(?<letLow>[a-z]{3})\\|(?<letUpp>[A-Z]{3})\\|(?<symb>[^<>]{3})<\\1$";
        Pattern pattern = Pattern.compile(regex);
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String num = matcher.group("num");
                String letLow = matcher.group("letLow");
                String letUpp = matcher.group("letUpp");
                String symb = matcher.group("symb");
                String password = num + letLow + letUpp + symb;
                System.out.printf("Password: %s%n", password);
            } else {
                System.out.println("Try another password!");
            }
        }
    }
}
