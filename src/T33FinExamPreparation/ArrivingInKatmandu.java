package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrivingInKatmandu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "^([A-Za-z\\d!@#$?]+)=(\\d+)<<(.+)$";
        String text = scanner.nextLine();


        while (!text.equals("Last note")) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);
            boolean isValid = false;

            if (matcher.find()) {
                String name = matcher.group(1);
                int length = Integer.parseInt(matcher.group(2));
                String geoHashCode = matcher.group(3);

                if (geoHashCode.length() == length) {
                    isValid = true;
                    String newName = transform(name);
                    System.out.printf("Coordinates found! %s -> %s%n", newName, geoHashCode);
                }

            }
            if (!isValid) {
                System.out.println("Nothing found!");
            }
            text = scanner.nextLine();
        }


    }

    private static String transform(String name) {
        StringBuilder newWord = new StringBuilder();
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            if ((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122)) {
                newWord.append(ch);
            }
        }
        return newWord.toString();
    }
}
