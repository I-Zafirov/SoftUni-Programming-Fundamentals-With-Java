package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String regex = "(.{1,})>(\\d{3})\\|([a-z]{3})\\|([A-Z]{3})\\|([^<>]{3})<\\1";
        Pattern pattern = Pattern.compile(regex);
        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                StringBuilder sb = new StringBuilder();
                sb.append(matcher.group(2));
                sb.append(matcher.group(3));
                sb.append(matcher.group(4));
                sb.append(matcher.group(5));
                String print = sb.toString();
                System.out.printf("Password: %s\n", print);
            } else {
                System.out.println("Try another password!");
            }
        }
    }
}
