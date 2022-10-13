package T33FinExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employees {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String regexEmail = "(?<name>[A-Z][a-z][a-z]+\\s[A-Z][a-z][a-z]+)#+(?<jobposition>(?<jp1>[a-zA-Z]+)&?(?<jp2>[a-zA-Z]+)?&?(?<jp3>[A-Za-z]+)?)\\d{2}(?<company>[A-Z][A-Za-z0-9]+\\s([J][S][C]|[L][t][d]\\.))";
            Pattern patternMail = Pattern.compile(regexEmail);
            Matcher matcher = patternMail.matcher(input);

            while (matcher.find()) {
                String jp1 = matcher.group("jp1") + " ";
                String jp2 = matcher.group("jp2") + " ";
                String jp3 = matcher.group("jp3") + " ";
                if (jp2.equals("null")) {
                    jp2 = "";
                }
                if (jp3.equals("null")) {
                    jp3 = "";
                }
                String result = matcher
                        .group("name") + " is " + jp1 + jp2 + jp3 + "at " + matcher.group("company");
                System.out.println(result);
            }
        }
    }
}
