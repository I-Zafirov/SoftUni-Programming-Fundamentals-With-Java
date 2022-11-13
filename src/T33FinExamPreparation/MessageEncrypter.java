package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageEncrypter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "([*@])([A-Z][a-z]{2,})\\1: \\[([A-Za-z])]\\|\\[([A-Za-z])]\\|\\[([A-Za-z])]\\|$";
        Pattern pattern = Pattern.compile(regex);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String name = matcher.group(2);
                String num1 = matcher.group(3);
                String num2 = matcher.group(4);
                String num3 = matcher.group(5);

                System.out.printf("%s: %d %d %d\n", name, (int) num1.charAt(0), (int) num2.charAt(0), (int) num3.charAt(0));
            } else {
                System.out.println("Valid message not found!");
            }
        }
    }
}
