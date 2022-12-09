package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheMessageIsInvalid2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String regex = "[!](?<command>[A-Z][a-z]{2,})!:\\[(?<msg>[A-Za-z]{8,})\\]";
        Pattern pattern = Pattern.compile(regex);
        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                System.out.printf("%s: ", matcher.group("command"));
                for (int j = 0; j < matcher.group("msg").length(); j++) {
                    int num = matcher.group("msg").charAt(j);
                    System.out.printf("%d ", num);
                }
                System.out.println();
            } else {
                System.out.println("The message is invalid");
            }
        }
    }
}
