package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BossRush {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String regex = "\\|(?<name>[A-Z]{4,})\\|:#(?<title>[A-Za-z]+ [A-za-z]+)#";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String name = matcher.group("name");
                int strength = name.length();
                String title = matcher.group("title");
                int armor = title.length();
                System.out.printf("%s, The %s%n", name, title);
                System.out.printf(">> Strength: %d%n", strength);
                System.out.printf(">> Armour: %d%n", armor);
            } else {
                System.out.println("Access denied!");
            }
        }


//        If the input is valid. Print in the following format:
//"{boss name}, The {title}
//>> Strength: {length of the name}
//>> Armour: {length of the title}"
//
//If the input is invalid, print "Access denied!"

    }
}
