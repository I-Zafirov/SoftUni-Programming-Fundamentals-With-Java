package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccessDeniedArmorStrength {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countPeoples = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < countPeoples; i++) {
            String peoples = scanner.nextLine();
            String regex = "(?<seperator>[|])(?<boss>[A-Z]{4,})\\1:(?<seperator2>[#])(?<title>[A-Za-z]{2,} [A-za-z]{2,})\\3";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(peoples);
            if (matcher.find()) {
                String boss = matcher.group("boss");
                String armor = matcher.group("title");

                System.out.printf("%s, The %s%n", boss, armor);
                System.out.printf(">> Strength: %d%n", boss.length());
                System.out.printf(">> Armor: %d%n", armor.length());
            } else {
                System.out.println("Access denied!");
            }
        }
    }
}
