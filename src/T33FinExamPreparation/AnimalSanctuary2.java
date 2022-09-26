package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnimalSanctuary2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());

        int weight = 0;
        while (num > 0) {
            String regex = "n:(.+);t:(.+);c--(.+)";
            String text = scanner.nextLine();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);

            if (matcher.find()) {
                String n = matcher.group(1);
                String k = matcher.group(2);
                String c = matcher.group(3);

                String name = transformString(n);
                String kind = transformString(k);
                String country = transformString(c);
                weight += transformWeight(n, k);
                System.out.printf("%s is a %s from %s%n", name, kind, country);
            }
            num--;
        }
        System.out.printf("Total weight of animals: %dKG", weight);
    }

    private static String transformString(String n) {
        StringBuilder newWord = new StringBuilder();

        for (int i = 0; i < n.length(); i++) {
            char c = n.charAt(i);
            if (c == ' ') {
                newWord.append(c);
            }
            if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
                newWord.append(c);
            }
        }
        return newWord.toString();
    }

    private static int transformWeight(String n, String k) {
        int totalSum = 0;

        for (int i = 0; i < n.length(); i++) {
            String b = "";
            char ch = n.charAt(i);
            if (Character.isDigit(ch)) {
                b += ch;
                totalSum += Integer.parseInt(b);
            }
        }
        for (int i = 0; i < k.length(); i++) {
            String b = "";
            char ch = k.charAt(i);
            if (Character.isDigit(ch)) {
                b += ch;
                totalSum += Integer.parseInt(b);
            }
        }
        return totalSum;
    }
}
