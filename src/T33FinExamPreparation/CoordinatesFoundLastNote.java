package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CoordinatesFoundLastNote {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        while (!"Last note".equals(command)) {
            String regex = "^(?<name>[A-Za-z0-9#@!$?]+)=(?<le>[0-9]+)<<(?<coord>[A-Za-z0-9]+)$";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(command);

            if (matcher.find()) {
                int length = Integer.parseInt(matcher.group("le"));
                String coord = matcher.group("coord");
                String name = matcher.group("name");
                if (length == coord.length()) {
                    String regexP = "(?<pe>[A-Za-z0-9]+)";
                    pattern = Pattern.compile(regexP);
                    matcher = pattern.matcher(name);
                    String peak1 = "";
                    while (matcher.find()) {
                        String pe = matcher.group("pe");
                        peak1 += pe;
                    }
                    System.out.println(String.format("Coordinates found! %s -> %s", peak1, coord));
                } else {
                    System.out.println("Nothing found!");
                }
            } else {
                System.out.println("Nothing found!");
            }
        }
    }
}
