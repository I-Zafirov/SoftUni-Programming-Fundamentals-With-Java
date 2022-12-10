package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TotalWeightOfAnimals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nn = Integer.parseInt(scanner.nextLine());
        int weight = 0;

        for (int i = 0; i < nn; i++) {
            String input = scanner.nextLine();
            String regex = "^n:(?<n>[^;]+);t:(?<t>[^;]+);c--(?<c>[^\\W\\d]+)$";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                String n = matcher.group("n");
                String k = matcher.group("t");
                String country = matcher.group("c");
                String name = "";
                String kind = "";
                for (int j = 0; j < n.length(); j++) {
                    char a = n.charAt(j);
                    if (Character.isAlphabetic(a)) {
                        name += a;
                    } else if (Character.isDigit(a)) {
                        int num = n.charAt(j) - 48;
                        weight += num;
                    }
                }
                for (int j = 0; j < k.length(); j++) {
                    char a = k.charAt(j);
                    if (Character.isAlphabetic(a)) {
                        kind += a;
                    } else if (Character.isDigit(a)) {
                        int num = k.charAt(j) - 48;
                        weight += num;
                    }
                }
                System.out.println(String.format("%s is a %s from %s", name, kind, country));
            }
        }
        System.out.println(String.format("Total weight of animals: %dKG", weight));
    }
}
