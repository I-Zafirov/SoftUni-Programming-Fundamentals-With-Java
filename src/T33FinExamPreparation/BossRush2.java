package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BossRush2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String regex = "\\|(?<boss>[A-Z]{4,})\\|:#(?<title>[A-Za-z]+ [A-Za-z]+)#";
        Pattern pattern = Pattern.compile(regex);
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String boss = matcher.group("boss");
                String title = matcher.group("title");
                System.out.println(String.format("%s, The %s", boss, title));
                System.out.println(String.format(">> Strength: %d", boss.length()));
                System.out.println(String.format(">> Armour: %d", title.length()));
            } else {
                System.out.println("Access denied!");
            }
        }
    }
}
