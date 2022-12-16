package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidMessageNotFoundCommand {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String a = scanner.nextLine();
            String regex = "^(\\$|%)(?<command>[A-Z][a-z]{2,})(\\1): (\\[(?<g1>\\d+)\\]\\|)(\\[(?<g2>\\d+)\\]\\|)(\\[(?<g3>\\d+)\\]\\|)$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(a);
            if (!matcher.find()) {
                System.out.println("Valid message not found!");
            } else {
                int num1 = Integer.parseInt(matcher.group("g1"));
                int num2 = Integer.parseInt(matcher.group("g2"));
                int num3 = Integer.parseInt(matcher.group("g3"));
                char c1 = (char) num1;
                char c2 = (char) num2;
                char c3 = (char) num3;
                System.out.print(matcher.group("command"));
                System.out.print(": ");
                System.out.print(c1);
                System.out.print(c2);
                System.out.println(c3);


            }
        }
    }
}
