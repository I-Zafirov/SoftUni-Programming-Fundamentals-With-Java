package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SantasSecretHelper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        String regex = "@(?<children>[A-Za-z]+)[^@\\-!:>]*!(?<behavior>[G]|[N])!";
        Pattern pattern = Pattern.compile(regex);

        while (!input.equals("end")) {
            String helpString = "";
            for (int i = 0; i < input.length(); i++) {
                int currentChar = input.charAt(i) - key;
                char currentSymbol = (char) currentChar;
                helpString += currentSymbol;
            }
            Matcher matcher = pattern.matcher(helpString);
            if (matcher.find()) {
                if (matcher.group("behavior").equals("G")) {
                    System.out.println(matcher.group("children"));
                }
            }
            input = scanner.nextLine();
        }
    }
}
