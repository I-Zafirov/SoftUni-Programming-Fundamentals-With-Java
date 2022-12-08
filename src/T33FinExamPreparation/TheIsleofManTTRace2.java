package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TheIsleofManTTRace2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            Pattern pattern = Pattern.compile("^([#$%*&])([A-Za-z]+)\\1=(\\d+)!!(.+)$");
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                String name = matcher.group(2);
                int leght = Integer.parseInt(matcher.group(3));
                String code = matcher.group(4);
                if (leght == code.length()) {
                    StringBuilder coodinate = new StringBuilder();
                    for (int i = 0; i < code.length(); i++) {
                        char ch = code.charAt(i);
                        ch = (char) (ch + leght);
                        coodinate = coodinate.append(ch);
                    }
                    System.out.printf("Coordinates found! %s -> %s%n", name, coodinate);
                    break;
                }
            }
            System.out.println("Nothing found!");


        }
    }
}
